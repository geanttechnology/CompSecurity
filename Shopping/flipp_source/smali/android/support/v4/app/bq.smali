.class public final Landroid/support/v4/app/bq;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field A:Landroid/app/Notification;

.field public B:Landroid/app/Notification;

.field public C:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field a:Landroid/content/Context;

.field b:Ljava/lang/CharSequence;

.field c:Ljava/lang/CharSequence;

.field public d:Landroid/app/PendingIntent;

.field e:Landroid/app/PendingIntent;

.field f:Landroid/widget/RemoteViews;

.field g:Landroid/graphics/Bitmap;

.field h:Ljava/lang/CharSequence;

.field i:I

.field public j:I

.field k:Z

.field l:Z

.field m:Landroid/support/v4/app/cb;

.field n:Ljava/lang/CharSequence;

.field o:I

.field p:I

.field q:Z

.field r:Ljava/lang/String;

.field s:Z

.field t:Ljava/lang/String;

.field u:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/support/v4/app/bm;",
            ">;"
        }
    .end annotation
.end field

.field v:Z

.field w:Ljava/lang/String;

.field x:Landroid/os/Bundle;

.field public y:I

.field z:I


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 906
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 874
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v4/app/bq;->k:Z

    .line 884
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Landroid/support/v4/app/bq;->u:Ljava/util/ArrayList;

    .line 885
    iput-boolean v4, p0, Landroid/support/v4/app/bq;->v:Z

    .line 888
    iput v4, p0, Landroid/support/v4/app/bq;->y:I

    .line 889
    iput v4, p0, Landroid/support/v4/app/bq;->z:I

    .line 892
    new-instance v0, Landroid/app/Notification;

    invoke-direct {v0}, Landroid/app/Notification;-><init>()V

    iput-object v0, p0, Landroid/support/v4/app/bq;->B:Landroid/app/Notification;

    .line 907
    iput-object p1, p0, Landroid/support/v4/app/bq;->a:Landroid/content/Context;

    .line 910
    iget-object v0, p0, Landroid/support/v4/app/bq;->B:Landroid/app/Notification;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    iput-wide v2, v0, Landroid/app/Notification;->when:J

    .line 911
    iget-object v0, p0, Landroid/support/v4/app/bq;->B:Landroid/app/Notification;

    const/4 v1, -0x1

    iput v1, v0, Landroid/app/Notification;->audioStreamType:I

    .line 912
    iput v4, p0, Landroid/support/v4/app/bq;->j:I

    .line 913
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Landroid/support/v4/app/bq;->C:Ljava/util/ArrayList;

    .line 914
    return-void
.end method

.method protected static c(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    .locals 2

    .prologue
    const/16 v1, 0x1400

    .line 1536
    if-nez p0, :cond_1

    .line 1540
    :cond_0
    :goto_0
    return-object p0

    .line 1537
    :cond_1
    invoke-interface {p0}, Ljava/lang/CharSequence;->length()I

    move-result v0

    if-le v0, v1, :cond_0

    .line 1538
    const/4 v0, 0x0

    invoke-interface {p0, v0, v1}, Ljava/lang/CharSequence;->subSequence(II)Ljava/lang/CharSequence;

    move-result-object p0

    goto :goto_0
.end method


# virtual methods
.method public final a()Landroid/support/v4/app/bq;
    .locals 2

    .prologue
    .line 1216
    iget-object v0, p0, Landroid/support/v4/app/bq;->B:Landroid/app/Notification;

    iget v1, v0, Landroid/app/Notification;->flags:I

    or-int/lit8 v1, v1, 0x10

    iput v1, v0, Landroid/app/Notification;->flags:I

    .line 1217
    return-object p0
.end method

.method public final a(I)Landroid/support/v4/app/bq;
    .locals 1

    .prologue
    .line 958
    iget-object v0, p0, Landroid/support/v4/app/bq;->B:Landroid/app/Notification;

    iput p1, v0, Landroid/app/Notification;->icon:I

    .line 959
    return-object p0
.end method

.method public final a(Landroid/support/v4/app/cb;)Landroid/support/v4/app/bq;
    .locals 2

    .prologue
    .line 1464
    iget-object v0, p0, Landroid/support/v4/app/bq;->m:Landroid/support/v4/app/cb;

    if-eq v0, p1, :cond_0

    .line 1465
    iput-object p1, p0, Landroid/support/v4/app/bq;->m:Landroid/support/v4/app/cb;

    .line 1466
    iget-object v0, p0, Landroid/support/v4/app/bq;->m:Landroid/support/v4/app/cb;

    if-eqz v0, :cond_0

    .line 1467
    iget-object v0, p0, Landroid/support/v4/app/bq;->m:Landroid/support/v4/app/cb;

    iget-object v1, v0, Landroid/support/v4/app/cb;->d:Landroid/support/v4/app/bq;

    if-eq v1, p0, :cond_0

    iput-object p0, v0, Landroid/support/v4/app/cb;->d:Landroid/support/v4/app/bq;

    iget-object v1, v0, Landroid/support/v4/app/cb;->d:Landroid/support/v4/app/bq;

    if-eqz v1, :cond_0

    iget-object v1, v0, Landroid/support/v4/app/cb;->d:Landroid/support/v4/app/bq;

    invoke-virtual {v1, v0}, Landroid/support/v4/app/bq;->a(Landroid/support/v4/app/cb;)Landroid/support/v4/app/bq;

    .line 1470
    :cond_0
    return-object p0
.end method

.method public final a(Ljava/lang/CharSequence;)Landroid/support/v4/app/bq;
    .locals 1

    .prologue
    .line 982
    invoke-static {p1}, Landroid/support/v4/app/bq;->c(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;

    move-result-object v0

    iput-object v0, p0, Landroid/support/v4/app/bq;->b:Ljava/lang/CharSequence;

    .line 983
    return-object p0
.end method

.method public final b(Ljava/lang/CharSequence;)Landroid/support/v4/app/bq;
    .locals 1

    .prologue
    .line 990
    invoke-static {p1}, Landroid/support/v4/app/bq;->c(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;

    move-result-object v0

    iput-object v0, p0, Landroid/support/v4/app/bq;->c:Ljava/lang/CharSequence;

    .line 991
    return-object p0
.end method
