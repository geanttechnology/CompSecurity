.class Lco/vine/android/recorder/RegularVineRecorder$2;
.super Ljava/lang/Object;
.source "RegularVineRecorder.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lco/vine/android/recorder/RegularVineRecorder;->onStop()Z
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/recorder/RegularVineRecorder;

.field final synthetic val$dialog:Landroid/app/ProgressDialog;


# direct methods
.method constructor <init>(Lco/vine/android/recorder/RegularVineRecorder;Landroid/app/ProgressDialog;)V
    .locals 0

    .prologue
    .line 242
    iput-object p1, p0, Lco/vine/android/recorder/RegularVineRecorder$2;->this$0:Lco/vine/android/recorder/RegularVineRecorder;

    iput-object p2, p0, Lco/vine/android/recorder/RegularVineRecorder$2;->val$dialog:Landroid/app/ProgressDialog;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 245
    iget-object v0, p0, Lco/vine/android/recorder/RegularVineRecorder$2;->val$dialog:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->show()V

    .line 246
    return-void
.end method
