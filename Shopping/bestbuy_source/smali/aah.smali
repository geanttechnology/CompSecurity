.class public final Laah;
.super Laag;


# annotations
.annotation runtime Lzf;
.end annotation


# instance fields
.field private final a:Landroid/content/Context;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/google/android/gms/internal/fh;Laaf;)V
    .locals 0

    invoke-direct {p0, p2, p3}, Laag;-><init>(Lcom/google/android/gms/internal/fh;Laaf;)V

    iput-object p1, p0, Laah;->a:Landroid/content/Context;

    return-void
.end method


# virtual methods
.method public c()V
    .locals 0

    return-void
.end method

.method public d()Laan;
    .locals 6

    invoke-static {}, Labi;->n()Landroid/os/Bundle;

    move-result-object v0

    new-instance v1, Luf;

    const-string v2, "gads:sdk_core_location"

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "gads:sdk_core_experiment_id"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-string v4, "gads:block_autoclicks_experiment_id"

    invoke-virtual {v0, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    const-string v5, "gads:spam_app_context:experiment_id"

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v2, v3, v4, v0}, Luf;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Laah;->a:Landroid/content/Context;

    new-instance v2, Lvs;

    invoke-direct {v2}, Lvs;-><init>()V

    new-instance v3, Labc;

    invoke-direct {v3}, Labc;-><init>()V

    invoke-static {v0, v1, v2, v3}, Laav;->a(Landroid/content/Context;Luf;Lvr;Labb;)Laav;

    move-result-object v0

    return-object v0
.end method
