import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

import java.util.Calendar
import java.util.Date

@Parcelize
@Serializable
data class Clock(
    val id: Int,
    val time: String,
    val local: String,
    val type: TypeClock,
    val desc: String? = null,
    val date: String
): Parcelable

enum class TypeClock {
    CLOCKIN, CLOCKOUT
}
