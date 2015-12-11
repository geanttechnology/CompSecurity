.class public Lco/vine/android/widget/TypingEditText;
.super Lco/vine/android/views/SdkEditText;
.source "TypingEditText.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/widget/TypingEditText$1;,
        Lco/vine/android/widget/TypingEditText$TypingHandler;,
        Lco/vine/android/widget/TypingEditText$TypingTextWatcher;,
        Lco/vine/android/widget/TypingEditText$TypingListener;
    }
.end annotation


# static fields
.field public static final DEFAULT_TIMEOUT:I = 0x1f4


# instance fields
.field private mHandler:Landroid/os/Handler;

.field private mListener:Lco/vine/android/widget/TypingEditText$TypingListener;

.field private mTimeout:J


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 31
    invoke-direct {p0, p1}, Lco/vine/android/views/SdkEditText;-><init>(Landroid/content/Context;)V

    .line 32
    invoke-direct {p0}, Lco/vine/android/widget/TypingEditText;->setup()V

    .line 33
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 37
    invoke-direct {p0, p1, p2}, Lco/vine/android/views/SdkEditText;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 38
    invoke-direct {p0}, Lco/vine/android/widget/TypingEditText;->setup()V

    .line 39
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 43
    invoke-direct {p0, p1, p2, p3}, Lco/vine/android/views/SdkEditText;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 44
    invoke-direct {p0}, Lco/vine/android/widget/TypingEditText;->setup()V

    .line 45
    return-void
.end method

.method static synthetic access$100(Lco/vine/android/widget/TypingEditText;)Landroid/os/Handler;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/widget/TypingEditText;

    .prologue
    .line 18
    iget-object v0, p0, Lco/vine/android/widget/TypingEditText;->mHandler:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic access$200(Lco/vine/android/widget/TypingEditText;)J
    .locals 2
    .param p0, "x0"    # Lco/vine/android/widget/TypingEditText;

    .prologue
    .line 18
    iget-wide v0, p0, Lco/vine/android/widget/TypingEditText;->mTimeout:J

    return-wide v0
.end method

.method static synthetic access$300(Lco/vine/android/widget/TypingEditText;)Lco/vine/android/widget/TypingEditText$TypingListener;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/widget/TypingEditText;

    .prologue
    .line 18
    iget-object v0, p0, Lco/vine/android/widget/TypingEditText;->mListener:Lco/vine/android/widget/TypingEditText$TypingListener;

    return-object v0
.end method

.method private setup()V
    .locals 2

    .prologue
    .line 60
    const-wide/16 v0, 0x1f4

    iput-wide v0, p0, Lco/vine/android/widget/TypingEditText;->mTimeout:J

    .line 61
    new-instance v0, Lco/vine/android/widget/TypingEditText$TypingHandler;

    invoke-direct {v0, p0}, Lco/vine/android/widget/TypingEditText$TypingHandler;-><init>(Lco/vine/android/widget/TypingEditText;)V

    iput-object v0, p0, Lco/vine/android/widget/TypingEditText;->mHandler:Landroid/os/Handler;

    .line 62
    new-instance v0, Lco/vine/android/widget/TypingEditText$TypingTextWatcher;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lco/vine/android/widget/TypingEditText$TypingTextWatcher;-><init>(Lco/vine/android/widget/TypingEditText;Lco/vine/android/widget/TypingEditText$1;)V

    invoke-virtual {p0, v0}, Lco/vine/android/widget/TypingEditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 63
    return-void
.end method


# virtual methods
.method public setTimeout(J)V
    .locals 0
    .param p1, "timeout"    # J

    .prologue
    .line 56
    iput-wide p1, p0, Lco/vine/android/widget/TypingEditText;->mTimeout:J

    .line 57
    return-void
.end method

.method public setTypingListener(Lco/vine/android/widget/TypingEditText$TypingListener;)V
    .locals 0
    .param p1, "listener"    # Lco/vine/android/widget/TypingEditText$TypingListener;

    .prologue
    .line 48
    iput-object p1, p0, Lco/vine/android/widget/TypingEditText;->mListener:Lco/vine/android/widget/TypingEditText$TypingListener;

    .line 49
    return-void
.end method
