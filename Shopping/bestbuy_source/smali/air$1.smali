.class Lair$1;
.super Lamb;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lair;->a(Laiw;)V
.end annotation


# instance fields
.field final synthetic a:Laiw;

.field final synthetic b:Lair;


# direct methods
.method constructor <init>(Lair;Laiw;)V
    .locals 0

    iput-object p1, p0, Lair$1;->b:Lair;

    iput-object p2, p0, Lair$1;->a:Laiw;

    invoke-direct {p0}, Lamb;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lajo;)V
    .locals 2

    iget-object v0, p0, Lair$1;->a:Laiw;

    new-instance v1, Laim;

    invoke-direct {v1, p1}, Laim;-><init>(Lajo;)V

    invoke-interface {v0, v1}, Laiw;->a(Laim;)V

    return-void
.end method
