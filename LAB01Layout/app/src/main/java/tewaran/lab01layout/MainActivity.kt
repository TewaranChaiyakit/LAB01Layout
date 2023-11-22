package tewaran.lab01layout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tewaran.lab01layout.ui.theme.LAB01LayoutTheme

data class Person(val name:String,
                  val studentID:String,
                  val imageID:Int)

class MainActivity : ComponentActivity() {
    var persons: List<Person> = listOf<Person>(
        Person("นายกมล จันบุตรดี", "643450063-8", R.drawable.dsc_6011),
        Person("นายเกียรติศักดิ์ คุ้มจอหอ", "643450064-6", R.drawable._7857080_625351944952802_6469313597909499904_n),
        Person("นายจักรพรรดิ์ อนุไพร", "643450065-4", R.drawable._85833293_1825783411158297_1711095314153205858_n),
        Person("นางสาวจีรณัฐ สีหาสุทธิ์", "643450066-2", R.drawable.female),
        Person("นายเจษฎา ลีรัตน์", "643450067-0", R.drawable._88333785_2214814308673615_8480510841249416814_n),
        Person("นายชัยธวัช หงษ์ไทย", "643450068-8", R.drawable.male),
        Person("นายชาญณรงค์ แต่งเมือง", "643450069-6", R.drawable._87783697_1694254497761572_2136933457974508474_n),
        Person("นายญาณศรณ์ คำพูล", "643450070-1", R.drawable.female),
        Person("นายฐิติศักดิ์ โสภณกีรติธาดา", "643450071-9", R.drawable.male),
        Person("นายณัฐกานต์ อินทรพานิชย์", "643450072-7", R.drawable.dsc_5914),
        Person("นายณัฐปกรณ์ ณ หนองคาย", "643450073-5", R.drawable.male),
        Person("นางสาวณิชกานต์ ไทยภักดี", "643450074-3", R.drawable.female),
        Person("นางสาวทัศนีย์ มลาตรี", "643450075-1", R.drawable._57725949_1773826863063200_8842889986305708817_n),
        Person("นายธนาธิป เตชะ", "643450076-9", R.drawable._80788415_1960866244292897_4819759521060386924_n),
        Person("นายปรเมศวร์ สิทธิมงคล", "643450078-5", R.drawable.male),
        Person("นายประสิทธิชัย จันทร์สม", "643450079-3", R.drawable._81017975_628770399435144_2802131188061451919_n),
        Person("นางสาวพรธิตา ขานพล", "643450080-8", R.drawable._34475126_726774071279347_8733704344983441564_n),
        Person("นางสาวพรฟ้า พาหา", "643450081-6", R.drawable.female),
        Person("นายพีระเดช โพธิ์หล้า", "643450082-4", R.drawable.male),
        Person("นายภวินท์ ครอบบัวบาน", "643450083-2", R.drawable.male),
        Person("นายวิญญู พรมภิภักดิ์", "643450084-0", R.drawable._58572601_1639463536551151_6186243358005717722_n),
        Person("นางสาวศรสวรรค์ ไพรอนันต์", "643450085-8", R.drawable._58116239_1686862591780436_8405701118899617250_n),
        Person("นายศรันย์ ซุ่นเส้ง", "643450086-6", R.drawable._28999788_1137934486894419_3534515177558695153_n),
        Person("นายศุภชัย หาญมาก", "643450087-4", R.drawable.male),
        Person("นางสาวสุธาดา โสภาพ", "643450089-0", R.drawable._54221685_578963477749170_3383322541397041299_n),
        Person("นายสุรยุทธ์ สูญควงษ์", "643450090-5", R.drawable.male),
        Person("นายอชิตพล สุทธิสน", "643450091-3", R.drawable.male),
        Person("นายอภิทุน ดวงจันทร์คล้อย", "643450092-1", R.drawable.male),
        Person("นายอภิวัฒน์ ดาวโคกสูงี", "643450093-9", R.drawable.male),
        Person("นางสาวอมรรัตน์ มาระเหว", "643450094-7", R.drawable._80428572_2103228683356710_5568452978731453155_n),
        Person("นายอรัญ ศรีสวัสดิ์", "643450095-5", R.drawable._30620266_856128732137761_1618527600485093142_n),
        Person("นางสาวกฤติยา สินโพธิ์", "643450320-4", R.drawable._80604041_3145317669096719_765443313508381226_n),
        Person("นายก้องภพ ตาดี", "643450321-2", R.drawable.male),
        Person("นายเกรียงศักดิ์ หมู่เมืองสอง", "643450322-0", R.drawable.male),
        Person("นายเจษฏา พบสมัย", "643450323-8", R.drawable.male),
        Person("นายเทวารัณย์ ชัยกิจ", "643450324-6", R.drawable.male),
        Person("นายธนบดี สวัสดี", "643450325-4", R.drawable.male),
        Person("นางสาวนภัสสร ดวงจันทร์", "643450326-2", R.drawable.female),
        Person("นางสาวนภาปิลันธ์ ชาวชายโขง", "643450327-0", R.drawable.female),
        Person("นางสาวนริศรา วงค์บุตรศรี", "643450328-8", R.drawable.female),
        Person("นางสาววรรณภา เบ้านาค", "643450330-1", R.drawable.female),
        Person("นายศุภชัย แสนประสิทธิ์", "643450332-7", R.drawable.male),
        Person("นายเสฏฐวุฒิ สาระกุล", "643450333-5", R.drawable.male),
        Person("นางสาวอฆพร ไร่ขาม", "643450334-3", R.drawable.female),
        Person("นายปฏิภัทร ดำทองสุก", "643450508-6", R.drawable.male),
        Person("นายกฤตวัฒน์ อินทรสิทธิ์", "643450644-8", R.drawable.male),
        Person("นายฌานวัฒน์ โอธินทรยุทธ", "643450645-6m", R.drawable.male),
        Person("นางสาวญญิตา พิชญกุลมงคล", "643450646-4", R.drawable.female),
        Person("นางสาวณัฐธิดา บุญพา", "643450647-2", R.drawable.female),
        Person("นายเทพทินกร พรมโสภา", "643450648-0", R.drawable.male),
        Person("นางสาวธัญเรศ บุญมี", "643450649-8", R.drawable.female),
        Person("นายรัตพงษ์ ปานเจริญ", "643450650-3", R.drawable.male),
        Person("นางสาววิภาดา บุญสะอาด", "643450651-1", R.drawable.female),
        Person("นายเวธน์วศิล พิรุณกาญจน์", "643450652-9", R.drawable.male),
        Person("นายศราวุธ สองเมือง", "643450653-7", R.drawable.male),
        Person("นายอภิสิทธิ์ ถาวรฤทธิ์", "643450654-5", R.drawable.male),
        Person("นางสาวอริยา เขียววิลัย", "643450655-3", R.drawable.female),
        Person("นางสาวฐิติพร สุขธีรอนันตชัย", "643450760-6", R.drawable.female),
        Person("นายธนากร ปรีดา", "643450761-4", R.drawable.male),
        Person("นางสาวพิมพ์ลภัส พูลสาริกิจ", "643450762-2", R.drawable.female),
        Person("นางสาววิสุดา หินจันทร์", "643450763-0", R.drawable.female),
        Person("นายธนกร ภิรมย์กุล", "643450789-0", R.drawable.male),
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LAB01LayoutTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) {
                    
                }
                LazyColumn(){
                    items(persons){
                            data -> PersonListItem(data)
                    }
                }
            }
        }
    }
}
@Composable
fun PersonListItem(data:Person){
    Row() {
        Image(
            painter = painterResource(data.imageID),
            contentDescription = data.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
        )
        Column {
            Text(data.name)
            Text(data.studentID )

        }

    }

}




