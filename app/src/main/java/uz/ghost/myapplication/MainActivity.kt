package uz.ghost.myapplication

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TimePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.snackbar.Snackbar
import uz.ghost.myapplication.databinding.ActivityMainBinding
import uz.ghost.myapplication.databinding.ContacktBinding

class MainActivity : AppCompatActivity() {
    private lateinit var  binding : ActivityMainBinding
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnView1.setOnClickListener {
            val alertDialog = AlertDialog.Builder(this).create()
            alertDialog.setTitle("Diqqat!!")
            alertDialog.setMessage("Sizning zaryadingiz oz qoldi. Agarda siz 30soniya ichida zaryadkaga qoymasez qurilma ochadi.")
            alertDialog.show()
        }
        binding.btnView2.setOnClickListener {
           val dialog = AlertDialog.Builder(this).create()
            val itemDialogBinding = ContacktBinding.inflate(layoutInflater)
            dialog.setView(itemDialogBinding.root)
            itemDialogBinding.btnClose.setOnClickListener {
                dialog.cancel()
            }
            dialog.show()
        }
        binding.btnView3.setOnClickListener {
          val myDialogFragment = FraGMENTIM()
            myDialogFragment.show(supportFragmentManager.beginTransaction(),"ixtiyoriy")
        }
        binding.btnView4.setOnClickListener {
            val datePickerDialog = DatePickerDialog(this)

            datePickerDialog.setOnDateSetListener{ view, year, month, dayOfMonth ->
                Toast.makeText(this, "${dayOfMonth}.${month+1}.$year", Toast.LENGTH_SHORT).show()
            }
            datePickerDialog.show()
        }
        binding.btnView5.setOnClickListener {
            val timePickerDialog = TimePickerDialog(
                this,
                object : TimePickerDialog.OnTimeSetListener {
                    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                        Toast.makeText(this@MainActivity, "$hourOfDay:$minute", Toast.LENGTH_SHORT).show()
                    }

                },
                24,
                60,
                true
            )
            timePickerDialog.updateTime(12, 50)
            timePickerDialog.show()
        }
        binding.btnView6.setOnClickListener {
           val dialog = BottomSheetDialog(this)
            val itemDialogBinding = ContacktBinding.inflate(layoutInflater)
            dialog.setContentView(itemDialogBinding.root)
            itemDialogBinding.btnClose.setOnClickListener {
                dialog.cancel()
            }
            dialog.show()
        }
        binding.btnView7.setOnClickListener {
            val snackbar = Snackbar.make(it, "Salom snackbar", Snackbar.LENGTH_LONG)

            snackbar.setAction("O'chirilmoqda", object : View.OnClickListener {
                override fun onClick(v: View?) {
                    Toast.makeText(this@MainActivity, "Qaytarildi", Toast.LENGTH_SHORT).show()
                }
            })

            snackbar.show()
        }
    }
}