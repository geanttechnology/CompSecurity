.class Laim$2;
.super Lalm;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Laim;->a(Laio;)V
.end annotation


# instance fields
.field final synthetic a:Laio;

.field final synthetic b:Laim;


# direct methods
.method constructor <init>(Laim;Laio;)V
    .locals 0

    iput-object p1, p0, Laim$2;->b:Laim;

    iput-object p2, p0, Laim$2;->a:Laio;

    invoke-direct {p0}, Lalm;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Laop;)V
    .locals 2

    iget-object v0, p0, Laim$2;->a:Laio;

    new-instance v1, Lank;

    invoke-direct {v1, p1}, Lank;-><init>(Laop;)V

    invoke-interface {v0, v1}, Laio;->b(Lank;)V

    return-void
.end method
