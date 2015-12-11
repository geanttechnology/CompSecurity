.class public final Lug;
.super Ljava/lang/Object;


# annotations
.annotation runtime Lzf;
.end annotation


# static fields
.field public static a:Laco;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Laco",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public static b:Laco;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Laco",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public static c:Laco;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Laco",
            "<",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation
.end field

.field public static d:Laco;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Laco",
            "<",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation
.end field

.field public static e:Laco;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Laco",
            "<",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation
.end field

.field public static f:Laco;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Laco",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public static g:Laco;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Laco",
            "<",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation
.end field

.field public static h:Laco;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Laco",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public static i:Laco;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Laco",
            "<",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation
.end field

.field public static j:Laco;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Laco",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field public static k:Laco;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Laco",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field public static l:Laco;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Laco",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field public static m:Laco;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Laco",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field public static n:Laco;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Laco",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private static final o:Landroid/os/Bundle;

.field private static p:Z


# direct methods
.method static constructor <clinit>()V
    .locals 6

    const/16 v5, 0xa

    const/4 v1, 0x0

    const/4 v4, 0x1

    const/4 v3, 0x0

    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    sput-object v0, Lug;->o:Landroid/os/Bundle;

    sput-boolean v3, Lug;->p:Z

    const-string v0, "gads:sdk_core_location"

    const-string v2, "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/sdk-core-v40.html"

    invoke-static {v0, v2}, Lug;->a(Ljava/lang/String;Ljava/lang/String;)Laco;

    move-result-object v0

    sput-object v0, Lug;->a:Laco;

    const-string v2, "gads:sdk_core_experiment_id"

    move-object v0, v1

    check-cast v0, Ljava/lang/String;

    invoke-static {v2, v0}, Lug;->a(Ljava/lang/String;Ljava/lang/String;)Laco;

    move-result-object v0

    sput-object v0, Lug;->b:Laco;

    const-string v0, "gads:sdk_crash_report_enabled"

    invoke-static {v0, v3}, Lug;->a(Ljava/lang/String;Z)Laco;

    move-result-object v0

    sput-object v0, Lug;->c:Laco;

    const-string v0, "gads:sdk_crash_report_full_stacktrace"

    invoke-static {v0, v3}, Lug;->a(Ljava/lang/String;Z)Laco;

    move-result-object v0

    sput-object v0, Lug;->d:Laco;

    const-string v0, "gads:block_autoclicks"

    invoke-static {v0, v3}, Lug;->a(Ljava/lang/String;Z)Laco;

    move-result-object v0

    sput-object v0, Lug;->e:Laco;

    const-string v2, "gads:block_autoclicks_experiment_id"

    move-object v0, v1

    check-cast v0, Ljava/lang/String;

    invoke-static {v2, v0}, Lug;->a(Ljava/lang/String;Ljava/lang/String;)Laco;

    move-result-object v0

    sput-object v0, Lug;->f:Laco;

    sput-boolean v4, Lug;->p:Z

    const-string v0, "gads:enable_content_fetching"

    invoke-static {v0, v3}, Lug;->a(Ljava/lang/String;Z)Laco;

    move-result-object v0

    sput-object v0, Lug;->i:Laco;

    const-string v0, "gads:content_length_weight"

    invoke-static {v0, v4}, Lug;->a(Ljava/lang/String;I)Laco;

    move-result-object v0

    sput-object v0, Lug;->j:Laco;

    const-string v0, "gads:content_age_weight"

    invoke-static {v0, v4}, Lug;->a(Ljava/lang/String;I)Laco;

    move-result-object v0

    sput-object v0, Lug;->k:Laco;

    const-string v0, "gads:min_content_len"

    const/16 v2, 0xb

    invoke-static {v0, v2}, Lug;->a(Ljava/lang/String;I)Laco;

    move-result-object v0

    sput-object v0, Lug;->l:Laco;

    const-string v0, "gads:fingerprint_number"

    invoke-static {v0, v5}, Lug;->a(Ljava/lang/String;I)Laco;

    move-result-object v0

    sput-object v0, Lug;->m:Laco;

    const-string v0, "gads:sleep_sec"

    invoke-static {v0, v5}, Lug;->a(Ljava/lang/String;I)Laco;

    move-result-object v0

    sput-object v0, Lug;->n:Laco;

    const-string v0, "gads:spam_app_context:enabled"

    invoke-static {v0, v3}, Lug;->a(Ljava/lang/String;Z)Laco;

    move-result-object v0

    sput-object v0, Lug;->g:Laco;

    const-string v0, "gads:spam_app_context:experiment_id"

    check-cast v1, Ljava/lang/String;

    invoke-static {v0, v1}, Lug;->a(Ljava/lang/String;Ljava/lang/String;)Laco;

    move-result-object v0

    sput-object v0, Lug;->h:Laco;

    return-void
.end method

.method private static a(Ljava/lang/String;I)Laco;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "I)",
            "Laco",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    sget-object v0, Lug;->o:Landroid/os/Bundle;

    invoke-virtual {v0, p0, p1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-static {p0, v0}, Laco;->a(Ljava/lang/String;Ljava/lang/Integer;)Laco;

    move-result-object v0

    return-object v0
.end method

.method private static a(Ljava/lang/String;Ljava/lang/String;)Laco;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Laco",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    sget-object v0, Lug;->o:Landroid/os/Bundle;

    invoke-virtual {v0, p0, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {p0, p1}, Laco;->a(Ljava/lang/String;Ljava/lang/String;)Laco;

    move-result-object v0

    return-object v0
.end method

.method private static a(Ljava/lang/String;Z)Laco;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Z)",
            "Laco",
            "<",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation

    sget-object v0, Lug;->o:Landroid/os/Bundle;

    invoke-virtual {v0, p0, p1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    invoke-static {p0, p1}, Laco;->a(Ljava/lang/String;Z)Laco;

    move-result-object v0

    return-object v0
.end method

.method public static a()Landroid/os/Bundle;
    .locals 1

    sget-object v0, Lug;->o:Landroid/os/Bundle;

    return-object v0
.end method
