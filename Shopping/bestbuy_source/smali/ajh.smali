.class public final Lajh;
.super Ljava/lang/Object;


# instance fields
.field private final a:Lakm;


# direct methods
.method constructor <init>(Lakm;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lajh;->a:Lakm;

    return-void
.end method


# virtual methods
.method public a(Z)V
    .locals 2

    :try_start_0
    iget-object v0, p0, Lajh;->a:Lakm;

    invoke-interface {v0, p1}, Lakm;->a(Z)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    return-void

    :catch_0
    move-exception v0

    new-instance v1, Lanl;

    invoke-direct {v1, v0}, Lanl;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method
