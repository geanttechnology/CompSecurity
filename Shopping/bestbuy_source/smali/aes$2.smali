.class Laes$2;
.super Laet;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Laes;->a(Lqm;Landroid/app/PendingIntent;)Lqq;
.end annotation


# instance fields
.field final synthetic b:Landroid/app/PendingIntent;

.field final synthetic c:Laes;


# direct methods
.method constructor <init>(Laes;Lqm;Landroid/app/PendingIntent;)V
    .locals 0

    iput-object p1, p0, Laes$2;->c:Laes;

    iput-object p3, p0, Laes$2;->b:Landroid/app/PendingIntent;

    invoke-direct {p0, p2}, Laet;-><init>(Lqm;)V

    return-void
.end method


# virtual methods
.method protected a(Lafd;)V
    .locals 2

    new-instance v0, Laes$2$1;

    invoke-direct {v0, p0}, Laes$2$1;-><init>(Laes$2;)V

    iget-object v1, p0, Laes$2;->b:Landroid/app/PendingIntent;

    invoke-virtual {p1, v1, v0}, Lafd;->a(Landroid/app/PendingIntent;Laih;)V

    return-void
.end method

.method protected synthetic b(Lqd;)V
    .locals 0

    check-cast p1, Lafd;

    invoke-virtual {p0, p1}, Laes$2;->a(Lafd;)V

    return-void
.end method
