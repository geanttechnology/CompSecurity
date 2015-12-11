.class public Lauj;
.super Ljava/lang/Object;


# static fields
.field public static final a:Latr;

.field public static final b:Laub;

.field public static final c:Lauf;

.field public static final d:Lauo;

.field public static final e:Laur;

.field public static final f:Lqf;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lqf",
            "<",
            "Lawc;",
            ">;"
        }
    .end annotation
.end field

.field public static final g:Lpx;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lpx",
            "<",
            "Lauk;",
            ">;"
        }
    .end annotation
.end field

.field private static final h:Lqe;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lqe",
            "<",
            "Lawc;",
            "Lauk;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 4

    new-instance v0, Lawh;

    invoke-direct {v0}, Lawh;-><init>()V

    sput-object v0, Lauj;->a:Latr;

    new-instance v0, Lavk;

    invoke-direct {v0}, Lavk;-><init>()V

    sput-object v0, Lauj;->b:Laub;

    new-instance v0, Lavm;

    invoke-direct {v0}, Lavm;-><init>()V

    sput-object v0, Lauj;->c:Lauf;

    new-instance v0, Lawg;

    invoke-direct {v0}, Lawg;-><init>()V

    sput-object v0, Lauj;->d:Lauo;

    new-instance v0, Lavv;

    invoke-direct {v0}, Lavv;-><init>()V

    sput-object v0, Lauj;->e:Laur;

    new-instance v0, Lqf;

    invoke-direct {v0}, Lqf;-><init>()V

    sput-object v0, Lauj;->f:Lqf;

    new-instance v0, Lauj$1;

    invoke-direct {v0}, Lauj$1;-><init>()V

    sput-object v0, Lauj;->h:Lqe;

    new-instance v0, Lpx;

    sget-object v1, Lauj;->h:Lqe;

    sget-object v2, Lauj;->f:Lqf;

    const/4 v3, 0x0

    new-array v3, v3, [Lcom/google/android/gms/common/api/Scope;

    invoke-direct {v0, v1, v2, v3}, Lpx;-><init>(Lqe;Lqf;[Lcom/google/android/gms/common/api/Scope;)V

    sput-object v0, Lauj;->g:Lpx;

    return-void
.end method
