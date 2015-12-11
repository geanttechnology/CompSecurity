.class Lco/vine/android/recorder/VineRecorder$31;
.super Ljava/lang/Object;
.source "VineRecorder.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/recorder/VineRecorder;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/recorder/VineRecorder;


# direct methods
.method constructor <init>(Lco/vine/android/recorder/VineRecorder;)V
    .locals 0

    .prologue
    .line 1928
    iput-object p1, p0, Lco/vine/android/recorder/VineRecorder$31;->this$0:Lco/vine/android/recorder/VineRecorder;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 1931
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder$31;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mProgressOverlay:Landroid/view/View;
    invoke-static {v0}, Lco/vine/android/recorder/VineRecorder;->access$4500(Lco/vine/android/recorder/VineRecorder;)Landroid/view/View;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 1932
    return-void
.end method
