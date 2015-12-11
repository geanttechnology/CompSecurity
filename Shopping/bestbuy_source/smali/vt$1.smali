.class Lvt$1;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lvt;->a(JJ)Lvz;
.end annotation


# instance fields
.field final synthetic a:Lvz;

.field final synthetic b:Lvt;


# direct methods
.method constructor <init>(Lvt;Lvz;)V
    .locals 0

    iput-object p1, p0, Lvt$1;->b:Lvt;

    iput-object p2, p0, Lvt$1;->a:Lvz;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    :try_start_0
    iget-object v0, p0, Lvt$1;->a:Lvz;

    iget-object v0, v0, Lvz;->c:Lwg;

    invoke-interface {v0}, Lwg;->c()V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    const-string v1, "Could not destroy mediation adapter."

    invoke-static {v1, v0}, Lacb;->d(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method
