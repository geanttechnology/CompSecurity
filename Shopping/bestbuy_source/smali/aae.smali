.class public final Laae;
.super Ljava/lang/Object;


# annotations
.annotation runtime Lzf;
.end annotation


# direct methods
.method public static a(Landroid/content/Context;Lcom/google/android/gms/internal/fh;Laaf;)Labn;
    .locals 1

    iget-object v0, p1, Lcom/google/android/gms/internal/fh;->k:Lcom/google/android/gms/internal/gs;

    iget-boolean v0, v0, Lcom/google/android/gms/internal/gs;->e:Z

    if-eqz v0, :cond_0

    invoke-static {p0, p1, p2}, Laae;->b(Landroid/content/Context;Lcom/google/android/gms/internal/fh;Laaf;)Labn;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    invoke-static {p0, p1, p2}, Laae;->c(Landroid/content/Context;Lcom/google/android/gms/internal/fh;Laaf;)Labn;

    move-result-object v0

    goto :goto_0
.end method

.method private static b(Landroid/content/Context;Lcom/google/android/gms/internal/fh;Laaf;)Labn;
    .locals 1

    const-string v0, "Fetching ad response from local ad request service."

    invoke-static {v0}, Lacb;->a(Ljava/lang/String;)V

    new-instance v0, Laah;

    invoke-direct {v0, p0, p1, p2}, Laah;-><init>(Landroid/content/Context;Lcom/google/android/gms/internal/fh;Laaf;)V

    invoke-virtual {v0}, Laah;->e()V

    return-object v0
.end method

.method private static c(Landroid/content/Context;Lcom/google/android/gms/internal/fh;Laaf;)Labn;
    .locals 1

    const-string v0, "Fetching ad response from remote ad request service."

    invoke-static {v0}, Lacb;->a(Ljava/lang/String;)V

    invoke-static {p0}, Lpu;->a(Landroid/content/Context;)I

    move-result v0

    if-eqz v0, :cond_0

    const-string v0, "Failed to connect to remote ad request service."

    invoke-static {v0}, Lacb;->e(Ljava/lang/String;)V

    const/4 v0, 0x0

    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Laai;

    invoke-direct {v0, p0, p1, p2}, Laai;-><init>(Landroid/content/Context;Lcom/google/android/gms/internal/fh;Laaf;)V

    goto :goto_0
.end method
