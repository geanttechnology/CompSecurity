.class abstract Lavx;
.super Laus;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Laus;"
    }
.end annotation


# instance fields
.field private a:Lqk;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lqk",
            "<TT;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lqk;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lqk",
            "<TT;>;)V"
        }
    .end annotation

    invoke-direct {p0}, Laus;-><init>()V

    iput-object p1, p0, Lavx;->a:Lqk;

    return-void
.end method


# virtual methods
.method public a(Ljava/lang/Object;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    iget-object v0, p0, Lavx;->a:Lqk;

    if-eqz v0, :cond_0

    invoke-interface {v0, p1}, Lqk;->a(Ljava/lang/Object;)V

    const/4 v0, 0x0

    iput-object v0, p0, Lavx;->a:Lqk;

    :cond_0
    return-void
.end method
