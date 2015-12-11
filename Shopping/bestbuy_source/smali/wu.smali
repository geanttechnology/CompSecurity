.class public Lwu;
.super Ljava/lang/Object;


# annotations
.annotation runtime Lzf;
.end annotation


# instance fields
.field private final a:Lcom/google/android/gms/internal/gu;

.field private final b:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private final c:Landroid/content/Context;

.field private d:Ljava/lang/String;

.field private e:J

.field private f:J

.field private g:Ljava/lang/String;

.field private h:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/google/android/gms/internal/gu;Ljava/util/Map;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/internal/gu;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lwu;->a:Lcom/google/android/gms/internal/gu;

    iput-object p2, p0, Lwu;->b:Ljava/util/Map;

    invoke-virtual {p1}, Lcom/google/android/gms/internal/gu;->k()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lwu;->c:Landroid/content/Context;

    invoke-direct {p0}, Lwu;->c()V

    return-void
.end method

.method static synthetic a(Lwu;)Landroid/content/Context;
    .locals 1

    iget-object v0, p0, Lwu;->c:Landroid/content/Context;

    return-object v0
.end method

.method private a(Ljava/lang/String;)Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lwu;->b:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/CharSequence;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    const-string v0, ""

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lwu;->b:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    goto :goto_0
.end method

.method static synthetic b(Lwu;)Lcom/google/android/gms/internal/gu;
    .locals 1

    iget-object v0, p0, Lwu;->a:Lcom/google/android/gms/internal/gu;

    return-object v0
.end method

.method private c()V
    .locals 2

    const-string v0, "description"

    invoke-direct {p0, v0}, Lwu;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lwu;->d:Ljava/lang/String;

    const-string v0, "summary"

    invoke-direct {p0, v0}, Lwu;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lwu;->g:Ljava/lang/String;

    iget-object v0, p0, Lwu;->b:Ljava/util/Map;

    const-string v1, "start"

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-static {v0}, Labq;->d(Ljava/lang/String;)J

    move-result-wide v0

    iput-wide v0, p0, Lwu;->e:J

    iget-object v0, p0, Lwu;->b:Ljava/util/Map;

    const-string v1, "end"

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-static {v0}, Labq;->d(Ljava/lang/String;)J

    move-result-wide v0

    iput-wide v0, p0, Lwu;->f:J

    const-string v0, "location"

    invoke-direct {p0, v0}, Lwu;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lwu;->h:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public a()V
    .locals 3

    new-instance v0, Lue;

    iget-object v1, p0, Lwu;->c:Landroid/content/Context;

    invoke-direct {v0, v1}, Lue;-><init>(Landroid/content/Context;)V

    invoke-virtual {v0}, Lue;->f()Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "This feature is not available on this version of the device."

    invoke-static {v0}, Lacb;->e(Ljava/lang/String;)V

    :goto_0
    return-void

    :cond_0
    new-instance v0, Landroid/app/AlertDialog$Builder;

    iget-object v1, p0, Lwu;->c:Landroid/content/Context;

    invoke-direct {v0, v1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    sget v1, Lcom/google/android/gms/R$string;->create_calendar_title:I

    const-string v2, "Create calendar event"

    invoke-static {v1, v2}, Labi;->a(ILjava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    sget v1, Lcom/google/android/gms/R$string;->create_calendar_message:I

    const-string v2, "Allow Ad to create a calendar event?"

    invoke-static {v1, v2}, Labi;->a(ILjava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    sget v1, Lcom/google/android/gms/R$string;->accept:I

    const-string v2, "Accept"

    invoke-static {v1, v2}, Labi;->a(ILjava/lang/String;)Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lwu$1;

    invoke-direct {v2, p0}, Lwu$1;-><init>(Lwu;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    sget v1, Lcom/google/android/gms/R$string;->decline:I

    const-string v2, "Decline"

    invoke-static {v1, v2}, Labi;->a(ILjava/lang/String;)Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lwu$2;

    invoke-direct {v2, p0}, Lwu$2;-><init>(Lwu;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    goto :goto_0
.end method

.method b()Landroid/content/Intent;
    .locals 4

    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.EDIT"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    sget-object v1, Landroid/provider/CalendarContract$Events;->CONTENT_URI:Landroid/net/Uri;

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    move-result-object v0

    const-string v1, "title"

    iget-object v2, p0, Lwu;->g:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    const-string v1, "eventLocation"

    iget-object v2, p0, Lwu;->h:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    const-string v1, "description"

    iget-object v2, p0, Lwu;->d:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    const-string v1, "beginTime"

    iget-wide v2, p0, Lwu;->e:J

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;J)Landroid/content/Intent;

    const-string v1, "endTime"

    iget-wide v2, p0, Lwu;->f:J

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;J)Landroid/content/Intent;

    const/high16 v1, 0x10000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    return-object v0
.end method
