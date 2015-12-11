.class public Lahn;
.super Ljava/lang/Object;

# interfaces
.implements Lahm;


# annotations
.annotation runtime Lzf;
.end annotation


# instance fields
.field private final a:Labe;

.field private final b:Lcom/google/android/gms/internal/gu;


# direct methods
.method public constructor <init>(Labe;Lcom/google/android/gms/internal/gu;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lahn;->a:Labe;

    iput-object p2, p0, Lahn;->b:Lcom/google/android/gms/internal/gu;

    return-void
.end method


# virtual methods
.method public a(Ljava/lang/String;)V
    .locals 3

    const-string v0, "An auto-clicking creative is blocked"

    invoke-static {v0}, Lacb;->a(Ljava/lang/String;)V

    new-instance v0, Landroid/net/Uri$Builder;

    invoke-direct {v0}, Landroid/net/Uri$Builder;-><init>()V

    const-string v1, "https"

    invoke-virtual {v0, v1}, Landroid/net/Uri$Builder;->scheme(Ljava/lang/String;)Landroid/net/Uri$Builder;

    const-string v1, "//pagead2.googlesyndication.com/pagead/gen_204"

    invoke-virtual {v0, v1}, Landroid/net/Uri$Builder;->path(Ljava/lang/String;)Landroid/net/Uri$Builder;

    const-string v1, "id"

    const-string v2, "gmob-apps-blocked-navigation"

    invoke-virtual {v0, v1, v2}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    const-string v1, "navigationURL"

    invoke-virtual {v0, v1, p1}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    :cond_0
    iget-object v1, p0, Lahn;->a:Labe;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lahn;->a:Labe;

    iget-object v1, v1, Labe;->b:Lcom/google/android/gms/internal/fj;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lahn;->a:Labe;

    iget-object v1, v1, Labe;->b:Lcom/google/android/gms/internal/fj;

    iget-object v1, v1, Lcom/google/android/gms/internal/fj;->o:Ljava/lang/String;

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_1

    const-string v1, "debugDialog"

    iget-object v2, p0, Lahn;->a:Labe;

    iget-object v2, v2, Labe;->b:Lcom/google/android/gms/internal/fj;

    iget-object v2, v2, Lcom/google/android/gms/internal/fj;->o:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    :cond_1
    iget-object v1, p0, Lahn;->b:Lcom/google/android/gms/internal/gu;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/gu;->getContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lahn;->b:Lcom/google/android/gms/internal/gu;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/gu;->i()Lcom/google/android/gms/internal/gs;

    move-result-object v2

    iget-object v2, v2, Lcom/google/android/gms/internal/gs;->b:Ljava/lang/String;

    invoke-virtual {v0}, Landroid/net/Uri$Builder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v2, v0}, Labq;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method
