.class Laim$3;
.super Lala;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Laim;->a(Lain;)V
.end annotation


# instance fields
.field final synthetic a:Lain;

.field final synthetic b:Laim;


# direct methods
.method constructor <init>(Laim;Lain;)V
    .locals 0

    iput-object p1, p0, Laim$3;->b:Laim;

    iput-object p2, p0, Laim$3;->a:Lain;

    invoke-direct {p0}, Lala;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Laop;)Lry;
    .locals 2

    iget-object v0, p0, Laim$3;->a:Lain;

    new-instance v1, Lank;

    invoke-direct {v1, p1}, Lank;-><init>(Laop;)V

    invoke-interface {v0, v1}, Lain;->a(Lank;)Landroid/view/View;

    move-result-object v0

    invoke-static {v0}, Lsb;->a(Ljava/lang/Object;)Lry;

    move-result-object v0

    return-object v0
.end method

.method public b(Laop;)Lry;
    .locals 2

    iget-object v0, p0, Laim$3;->a:Lain;

    new-instance v1, Lank;

    invoke-direct {v1, p1}, Lank;-><init>(Laop;)V

    invoke-interface {v0, v1}, Lain;->b(Lank;)Landroid/view/View;

    move-result-object v0

    invoke-static {v0}, Lsb;->a(Ljava/lang/Object;)Lry;

    move-result-object v0

    return-object v0
.end method
