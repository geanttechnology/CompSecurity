.class Lajd$1;
.super Lamb;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lajd;->a(Laiw;)V
.end annotation


# instance fields
.field final synthetic a:Laiw;

.field final synthetic b:Lajd;


# direct methods
.method constructor <init>(Lajd;Laiw;)V
    .locals 0

    iput-object p1, p0, Lajd$1;->b:Lajd;

    iput-object p2, p0, Lajd$1;->a:Laiw;

    invoke-direct {p0}, Lamb;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lajo;)V
    .locals 2

    iget-object v0, p0, Lajd$1;->a:Laiw;

    new-instance v1, Laim;

    invoke-direct {v1, p1}, Laim;-><init>(Lajo;)V

    invoke-interface {v0, v1}, Laiw;->a(Laim;)V

    return-void
.end method
