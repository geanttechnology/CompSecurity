.class public final Lcn/jpush/android/service/r;
.super Ljava/lang/Object;


# static fields
.field private static a:Lcn/jpush/android/service/r;


# instance fields
.field private b:Landroid/os/PowerManager$WakeLock;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const/4 v0, 0x0

    sput-object v0, Lcn/jpush/android/service/r;->a:Lcn/jpush/android/service/r;

    return-void
.end method

.method private constructor <init>()V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput-object v0, p0, Lcn/jpush/android/service/r;->b:Landroid/os/PowerManager$WakeLock;

    return-void
.end method

.method public static a()Lcn/jpush/android/service/r;
    .locals 1

    sget-object v0, Lcn/jpush/android/service/r;->a:Lcn/jpush/android/service/r;

    if-nez v0, :cond_0

    new-instance v0, Lcn/jpush/android/service/r;

    invoke-direct {v0}, Lcn/jpush/android/service/r;-><init>()V

    sput-object v0, Lcn/jpush/android/service/r;->a:Lcn/jpush/android/service/r;

    :cond_0
    sget-object v0, Lcn/jpush/android/service/r;->a:Lcn/jpush/android/service/r;

    return-object v0
.end method


# virtual methods
.method public final a(Landroid/os/PowerManager$WakeLock;)V
    .locals 0

    iput-object p1, p0, Lcn/jpush/android/service/r;->b:Landroid/os/PowerManager$WakeLock;

    return-void
.end method

.method public final b()Landroid/os/PowerManager$WakeLock;
    .locals 1

    iget-object v0, p0, Lcn/jpush/android/service/r;->b:Landroid/os/PowerManager$WakeLock;

    return-object v0
.end method
