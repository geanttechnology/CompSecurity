.class public Lasv;
.super Lage;


# instance fields
.field private a:Lasu;

.field private final b:Lcom/google/android/gms/wallet/fragment/WalletFragment;


# direct methods
.method public constructor <init>(Lcom/google/android/gms/wallet/fragment/WalletFragment;)V
    .locals 0

    invoke-direct {p0}, Lage;-><init>()V

    iput-object p1, p0, Lasv;->b:Lcom/google/android/gms/wallet/fragment/WalletFragment;

    return-void
.end method


# virtual methods
.method public a(IILandroid/os/Bundle;)V
    .locals 2

    iget-object v0, p0, Lasv;->a:Lasu;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lasv;->a:Lasu;

    iget-object v1, p0, Lasv;->b:Lcom/google/android/gms/wallet/fragment/WalletFragment;

    invoke-interface {v0, v1, p1, p2, p3}, Lasu;->a(Lcom/google/android/gms/wallet/fragment/WalletFragment;IILandroid/os/Bundle;)V

    :cond_0
    return-void
.end method
