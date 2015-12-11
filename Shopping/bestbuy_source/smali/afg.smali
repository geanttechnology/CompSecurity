.class final Lafg;
.super Lada;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lacy",
        "<",
        "Laex;",
        ">.ada<",
        "Laih;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic b:Lafd;

.field private final c:I

.field private final d:[Ljava/lang/String;

.field private final e:Landroid/app/PendingIntent;

.field private final f:I


# direct methods
.method public constructor <init>(Lafd;ILaih;ILandroid/app/PendingIntent;)V
    .locals 1

    const/4 v0, 0x1

    iput-object p1, p0, Lafg;->b:Lafd;

    invoke-direct {p0, p1, p3}, Lada;-><init>(Lacy;Ljava/lang/Object;)V

    if-ne p2, v0, :cond_0

    :goto_0
    invoke-static {v0}, Lacu;->a(Z)V

    iput p2, p0, Lafg;->f:I

    invoke-static {p4}, Laia;->a(I)I

    move-result v0

    iput v0, p0, Lafg;->c:I

    iput-object p5, p0, Lafg;->e:Landroid/app/PendingIntent;

    const/4 v0, 0x0

    iput-object v0, p0, Lafg;->d:[Ljava/lang/String;

    return-void

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public constructor <init>(Lafd;ILaih;I[Ljava/lang/String;)V
    .locals 1

    iput-object p1, p0, Lafg;->b:Lafd;

    invoke-direct {p0, p1, p3}, Lada;-><init>(Lacy;Ljava/lang/Object;)V

    const/4 v0, 0x2

    if-ne p2, v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-static {v0}, Lacu;->a(Z)V

    iput p2, p0, Lafg;->f:I

    invoke-static {p4}, Laia;->a(I)I

    move-result v0

    iput v0, p0, Lafg;->c:I

    iput-object p5, p0, Lafg;->d:[Ljava/lang/String;

    const/4 v0, 0x0

    iput-object v0, p0, Lafg;->e:Landroid/app/PendingIntent;

    return-void

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method protected a()V
    .locals 0

    return-void
.end method

.method protected a(Laih;)V
    .locals 3

    if-eqz p1, :cond_0

    iget v0, p0, Lafg;->f:I

    packed-switch v0, :pswitch_data_0

    const-string v0, "LocationClientImpl"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Unsupported action: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lafg;->f:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->wtf(Ljava/lang/String;Ljava/lang/String;)I

    :cond_0
    :goto_0
    return-void

    :pswitch_0
    iget v0, p0, Lafg;->c:I

    iget-object v1, p0, Lafg;->e:Landroid/app/PendingIntent;

    invoke-interface {p1, v0, v1}, Laih;->a(ILandroid/app/PendingIntent;)V

    goto :goto_0

    :pswitch_1
    iget v0, p0, Lafg;->c:I

    iget-object v1, p0, Lafg;->d:[Ljava/lang/String;

    invoke-interface {p1, v0, v1}, Laih;->a(I[Ljava/lang/String;)V

    goto :goto_0

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method protected synthetic a(Ljava/lang/Object;)V
    .locals 0

    check-cast p1, Laih;

    invoke-virtual {p0, p1}, Lafg;->a(Laih;)V

    return-void
.end method
