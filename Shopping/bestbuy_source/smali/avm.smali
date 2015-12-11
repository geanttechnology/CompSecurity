.class public final Lavm;
.super Ljava/lang/Object;

# interfaces
.implements Lauf;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lqm;)Lqq;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lqm;",
            ")",
            "Lqq",
            "<",
            "Laug;",
            ">;"
        }
    .end annotation

    new-instance v0, Lavm$1;

    invoke-direct {v0, p0, p1}, Lavm$1;-><init>(Lavm;Lqm;)V

    invoke-interface {p1, v0}, Lqm;->a(Lqj;)Lqj;

    move-result-object v0

    return-object v0
.end method
