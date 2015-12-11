.class Lco/vine/android/recorder/InlineVineRecorder$1;
.super Ljava/lang/Object;
.source "InlineVineRecorder.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/recorder/InlineVineRecorder;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/recorder/InlineVineRecorder;


# direct methods
.method constructor <init>(Lco/vine/android/recorder/InlineVineRecorder;)V
    .locals 0

    .prologue
    .line 35
    iput-object p1, p0, Lco/vine/android/recorder/InlineVineRecorder$1;->this$0:Lco/vine/android/recorder/InlineVineRecorder;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lco/vine/android/recorder/InlineVineRecorder$1;->this$0:Lco/vine/android/recorder/InlineVineRecorder;

    invoke-virtual {v0}, Lco/vine/android/recorder/InlineVineRecorder;->startRelativeTime()Z

    .line 38
    return-void
.end method
