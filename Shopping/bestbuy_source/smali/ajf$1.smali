.class Lajf$1;
.super Lamz;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lajf;->a(Laix;)V
.end annotation


# instance fields
.field final synthetic a:Laix;

.field final synthetic b:Lajf;


# direct methods
.method constructor <init>(Lajf;Laix;)V
    .locals 0

    iput-object p1, p0, Lajf$1;->b:Lajf;

    iput-object p2, p0, Lajf$1;->a:Laix;

    invoke-direct {p0}, Lamz;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lakd;)V
    .locals 2

    iget-object v0, p0, Lajf$1;->a:Laix;

    new-instance v1, Laiy;

    invoke-direct {v1, p1}, Laiy;-><init>(Lakd;)V

    invoke-interface {v0, v1}, Laix;->a(Laiy;)V

    return-void
.end method
