.class Laim$1;
.super Lame;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Laim;->a(Laiq;)V
.end annotation


# instance fields
.field final synthetic a:Laiq;

.field final synthetic b:Laim;


# direct methods
.method constructor <init>(Laim;Laiq;)V
    .locals 0

    iput-object p1, p0, Laim$1;->b:Laim;

    iput-object p2, p0, Laim$1;->a:Laiq;

    invoke-direct {p0}, Lame;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Laop;)Z
    .locals 2

    iget-object v0, p0, Laim$1;->a:Laiq;

    new-instance v1, Lank;

    invoke-direct {v1, p1}, Lank;-><init>(Laop;)V

    invoke-interface {v0, v1}, Laiq;->a(Lank;)Z

    move-result v0

    return v0
.end method
