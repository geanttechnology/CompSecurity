.class public final Ladb;
.super Ladn;


# instance fields
.field private a:Lacy;


# direct methods
.method public constructor <init>(Lacy;)V
    .locals 0

    invoke-direct {p0}, Ladn;-><init>()V

    iput-object p1, p0, Ladb;->a:Lacy;

    return-void
.end method


# virtual methods
.method public a(ILandroid/os/IBinder;Landroid/os/Bundle;)V
    .locals 2

    const-string v0, "onPostInitComplete can be called only once per call to getServiceFromBroker"

    iget-object v1, p0, Ladb;->a:Lacy;

    invoke-static {v0, v1}, Lady;->a(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v0, p0, Ladb;->a:Lacy;

    invoke-virtual {v0, p1, p2, p3}, Lacy;->a(ILandroid/os/IBinder;Landroid/os/Bundle;)V

    const/4 v0, 0x0

    iput-object v0, p0, Ladb;->a:Lacy;

    return-void
.end method
