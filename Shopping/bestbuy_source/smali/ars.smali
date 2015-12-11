.class Lars;
.super Ljava/lang/Object;


# instance fields
.field private a:Larf;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Larf",
            "<",
            "Lwk;",
            ">;"
        }
    .end annotation
.end field

.field private b:Lwk;


# direct methods
.method public constructor <init>(Larf;Lwk;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Larf",
            "<",
            "Lwk;",
            ">;",
            "Lwk;",
            ")V"
        }
    .end annotation

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lars;->a:Larf;

    iput-object p2, p0, Lars;->b:Lwk;

    return-void
.end method


# virtual methods
.method public a()Larf;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Larf",
            "<",
            "Lwk;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lars;->a:Larf;

    return-object v0
.end method

.method public b()Lwk;
    .locals 1

    iget-object v0, p0, Lars;->b:Lwk;

    return-object v0
.end method
