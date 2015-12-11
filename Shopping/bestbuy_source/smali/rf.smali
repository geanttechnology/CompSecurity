.class public Lrf;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic a:Lcom/google/android/gms/common/api/g;

.field private final b:I

.field private final c:Lpp;


# direct methods
.method public constructor <init>(Lcom/google/android/gms/common/api/g;ILpp;)V
    .locals 0

    iput-object p1, p0, Lrf;->a:Lcom/google/android/gms/common/api/g;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput p2, p0, Lrf;->b:I

    iput-object p3, p0, Lrf;->c:Lpp;

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    iget-object v0, p0, Lrf;->c:Lpp;

    invoke-virtual {v0}, Lpp;->a()Z

    move-result v0

    if-eqz v0, :cond_0

    :try_start_0
    iget-object v0, p0, Lrf;->a:Lcom/google/android/gms/common/api/g;

    invoke-virtual {v0}, Lcom/google/android/gms/common/api/g;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->getFragments()Ljava/util/List;

    move-result-object v0

    iget-object v1, p0, Lrf;->a:Lcom/google/android/gms/common/api/g;

    invoke-interface {v0, v1}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v0

    add-int/lit8 v0, v0, 0x1

    shl-int/lit8 v0, v0, 0x10

    add-int/lit8 v0, v0, 0x1

    iget-object v1, p0, Lrf;->c:Lpp;

    iget-object v2, p0, Lrf;->a:Lcom/google/android/gms/common/api/g;

    invoke-virtual {v2}, Lcom/google/android/gms/common/api/g;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-virtual {v1, v2, v0}, Lpp;->a(Landroid/app/Activity;I)V
    :try_end_0
    .catch Landroid/content/IntentSender$SendIntentException; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    iget-object v0, p0, Lrf;->a:Lcom/google/android/gms/common/api/g;

    invoke-static {v0}, Lcom/google/android/gms/common/api/g;->a(Lcom/google/android/gms/common/api/g;)V

    goto :goto_0

    :cond_0
    iget-object v0, p0, Lrf;->c:Lpp;

    invoke-virtual {v0}, Lpp;->c()I

    move-result v0

    invoke-static {v0}, Lpu;->c(I)Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lrf;->c:Lpp;

    invoke-virtual {v0}, Lpp;->c()I

    move-result v0

    iget-object v1, p0, Lrf;->a:Lcom/google/android/gms/common/api/g;

    invoke-virtual {v1}, Lcom/google/android/gms/common/api/g;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v2, p0, Lrf;->a:Lcom/google/android/gms/common/api/g;

    const/4 v3, 0x2

    iget-object v4, p0, Lrf;->a:Lcom/google/android/gms/common/api/g;

    invoke-static {v0, v1, v2, v3, v4}, Lpu;->a(ILandroid/app/Activity;Landroid/support/v4/app/Fragment;ILandroid/content/DialogInterface$OnCancelListener;)Z

    goto :goto_0

    :cond_1
    iget-object v0, p0, Lrf;->a:Lcom/google/android/gms/common/api/g;

    iget v1, p0, Lrf;->b:I

    iget-object v2, p0, Lrf;->c:Lpp;

    invoke-static {v0, v1, v2}, Lcom/google/android/gms/common/api/g;->a(Lcom/google/android/gms/common/api/g;ILpp;)V

    goto :goto_0
.end method
