.class public Lco/vine/android/recorder/FFmpegInvoke;
.super Ljava/lang/Object;
.source "FFmpegInvoke.java"


# instance fields
.field private mPath:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "path"    # Ljava/lang/String;

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 11
    iput-object p1, p0, Lco/vine/android/recorder/FFmpegInvoke;->mPath:Ljava/lang/String;

    .line 12
    return-void
.end method

.method private native run(Ljava/lang/String;[Ljava/lang/String;)I
.end method


# virtual methods
.method public native YUVtoRBG([I[BII)V
.end method

.method public run([Ljava/lang/String;)I
    .locals 1
    .param p1, "args"    # [Ljava/lang/String;

    .prologue
    .line 15
    iget-object v0, p0, Lco/vine/android/recorder/FFmpegInvoke;->mPath:Ljava/lang/String;

    invoke-direct {p0, v0, p1}, Lco/vine/android/recorder/FFmpegInvoke;->run(Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    return v0
.end method
