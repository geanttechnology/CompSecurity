.class public Lasr;
.super Lage;


# instance fields
.field private a:Lasq;

.field private final b:Lcom/google/android/gms/wallet/fragment/SupportWalletFragment;


# direct methods
.method public constructor <init>(Lcom/google/android/gms/wallet/fragment/SupportWalletFragment;)V
    .locals 0

    invoke-direct {p0}, Lage;-><init>()V

    iput-object p1, p0, Lasr;->b:Lcom/google/android/gms/wallet/fragment/SupportWalletFragment;

    return-void
.end method


# virtual methods
.method public a(IILandroid/os/Bundle;)V
    .locals 2

    iget-object v0, p0, Lasr;->a:Lasq;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lasr;->a:Lasq;

    iget-object v1, p0, Lasr;->b:Lcom/google/android/gms/wallet/fragment/SupportWalletFragment;

    invoke-interface {v0, v1, p1, p2, p3}, Lasq;->a(Lcom/google/android/gms/wallet/fragment/SupportWalletFragment;IILandroid/os/Bundle;)V

    :cond_0
    return-void
.end method
