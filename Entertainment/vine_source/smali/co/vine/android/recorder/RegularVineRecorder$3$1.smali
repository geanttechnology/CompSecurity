.class Lco/vine/android/recorder/RegularVineRecorder$3$1;
.super Ljava/lang/Object;
.source "RegularVineRecorder.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lco/vine/android/recorder/RegularVineRecorder$3;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lco/vine/android/recorder/RegularVineRecorder$3;


# direct methods
.method constructor <init>(Lco/vine/android/recorder/RegularVineRecorder$3;)V
    .locals 0

    .prologue
    .line 299
    iput-object p1, p0, Lco/vine/android/recorder/RegularVineRecorder$3$1;->this$1:Lco/vine/android/recorder/RegularVineRecorder$3;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 302
    iget-object v0, p0, Lco/vine/android/recorder/RegularVineRecorder$3$1;->this$1:Lco/vine/android/recorder/RegularVineRecorder$3;

    iget-object v0, v0, Lco/vine/android/recorder/RegularVineRecorder$3;->this$0:Lco/vine/android/recorder/RegularVineRecorder;

    iget-object v0, v0, Lco/vine/android/recorder/RegularVineRecorder;->mActivity:Landroid/app/Activity;

    if-eqz v0, :cond_0

    .line 303
    iget-object v0, p0, Lco/vine/android/recorder/RegularVineRecorder$3$1;->this$1:Lco/vine/android/recorder/RegularVineRecorder$3;

    iget-object v0, v0, Lco/vine/android/recorder/RegularVineRecorder$3;->this$0:Lco/vine/android/recorder/RegularVineRecorder;

    iget-object v0, v0, Lco/vine/android/recorder/RegularVineRecorder;->mActivity:Landroid/app/Activity;

    iget-object v1, p0, Lco/vine/android/recorder/RegularVineRecorder$3$1;->this$1:Lco/vine/android/recorder/RegularVineRecorder$3;

    iget-object v1, v1, Lco/vine/android/recorder/RegularVineRecorder$3;->this$0:Lco/vine/android/recorder/RegularVineRecorder;

    iget-object v1, v1, Lco/vine/android/recorder/RegularVineRecorder;->mDeviceNotSupportedString:Ljava/lang/String;

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 304
    iget-object v0, p0, Lco/vine/android/recorder/RegularVineRecorder$3$1;->this$1:Lco/vine/android/recorder/RegularVineRecorder$3;

    iget-object v0, v0, Lco/vine/android/recorder/RegularVineRecorder$3;->this$0:Lco/vine/android/recorder/RegularVineRecorder;

    iget-object v0, v0, Lco/vine/android/recorder/RegularVineRecorder;->mActivity:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->finish()V

    .line 306
    :cond_0
    return-void
.end method
