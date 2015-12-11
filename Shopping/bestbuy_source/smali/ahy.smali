.class public Lahy;
.super Ljava/lang/Object;


# static fields
.field public static final a:Lpx;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lpx",
            "<",
            "Lqa;",
            ">;"
        }
    .end annotation
.end field

.field public static b:Lahr;

.field public static c:Lahu;

.field private static final d:Lqf;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lqf",
            "<",
            "Lafd;",
            ">;"
        }
    .end annotation
.end field

.field private static final e:Lqe;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lqe",
            "<",
            "Lafd;",
            "Lqa;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 4

    new-instance v0, Lqf;

    invoke-direct {v0}, Lqf;-><init>()V

    sput-object v0, Lahy;->d:Lqf;

    new-instance v0, Lahy$1;

    invoke-direct {v0}, Lahy$1;-><init>()V

    sput-object v0, Lahy;->e:Lqe;

    new-instance v0, Lpx;

    sget-object v1, Lahy;->e:Lqe;

    sget-object v2, Lahy;->d:Lqf;

    const/4 v3, 0x0

    new-array v3, v3, [Lcom/google/android/gms/common/api/Scope;

    invoke-direct {v0, v1, v2, v3}, Lpx;-><init>(Lqe;Lqf;[Lcom/google/android/gms/common/api/Scope;)V

    sput-object v0, Lahy;->a:Lpx;

    new-instance v0, Laeq;

    invoke-direct {v0}, Laeq;-><init>()V

    sput-object v0, Lahy;->b:Lahr;

    new-instance v0, Laes;

    invoke-direct {v0}, Laes;-><init>()V

    sput-object v0, Lahy;->c:Lahu;

    return-void
.end method

.method static synthetic a()Lqf;
    .locals 1

    sget-object v0, Lahy;->d:Lqf;

    return-object v0
.end method
