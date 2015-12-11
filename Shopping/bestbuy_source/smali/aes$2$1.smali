.class Laes$2$1;
.super Ljava/lang/Object;

# interfaces
.implements Laih;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Laes$2;->a(Lafd;)V
.end annotation


# instance fields
.field final synthetic a:Laes$2;


# direct methods
.method constructor <init>(Laes$2;)V
    .locals 0

    iput-object p1, p0, Laes$2$1;->a:Laes$2;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(ILandroid/app/PendingIntent;)V
    .locals 2

    iget-object v0, p0, Laes$2$1;->a:Laes$2;

    invoke-static {p1}, Laia;->b(I)Lcom/google/android/gms/common/api/Status;

    move-result-object v1

    invoke-virtual {v0, v1}, Laes$2;->a(Lqt;)V

    return-void
.end method

.method public a(I[Ljava/lang/String;)V
    .locals 2

    const-string v0, "GeofencingImpl"

    const-string v1, "Request ID callback shouldn\'t have been called"

    invoke-static {v0, v1}, Landroid/util/Log;->wtf(Ljava/lang/String;Ljava/lang/String;)I

    return-void
.end method
