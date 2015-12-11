.class public Lawd;
.super Lauz;


# instance fields
.field private a:Latt;

.field private b:Lauc;

.field private c:Lauh;

.field private final d:[Landroid/content/IntentFilter;


# direct methods
.method private constructor <init>(Latt;Lauc;Lauh;[Landroid/content/IntentFilter;)V
    .locals 0

    invoke-direct {p0}, Lauz;-><init>()V

    iput-object p1, p0, Lawd;->a:Latt;

    iput-object p2, p0, Lawd;->b:Lauc;

    iput-object p3, p0, Lawd;->c:Lauh;

    iput-object p4, p0, Lawd;->d:[Landroid/content/IntentFilter;

    return-void
.end method

.method public static a(Latt;[Landroid/content/IntentFilter;)Lawd;
    .locals 2

    const/4 v1, 0x0

    new-instance v0, Lawd;

    invoke-direct {v0, p0, v1, v1, p1}, Lawd;-><init>(Latt;Lauc;Lauh;[Landroid/content/IntentFilter;)V

    return-object v0
.end method

.method public static a(Lauc;[Landroid/content/IntentFilter;)Lawd;
    .locals 2

    const/4 v1, 0x0

    new-instance v0, Lawd;

    invoke-direct {v0, v1, p0, v1, p1}, Lawd;-><init>(Latt;Lauc;Lauh;[Landroid/content/IntentFilter;)V

    return-object v0
.end method

.method public static a(Lauh;)Lawd;
    .locals 2

    const/4 v1, 0x0

    new-instance v0, Lawd;

    invoke-direct {v0, v1, v1, p0, v1}, Lawd;-><init>(Latt;Lauc;Lauh;[Landroid/content/IntentFilter;)V

    return-object v0
.end method


# virtual methods
.method public a()V
    .locals 1

    const/4 v0, 0x0

    iput-object v0, p0, Lawd;->a:Latt;

    iput-object v0, p0, Lawd;->b:Lauc;

    iput-object v0, p0, Lawd;->c:Lauh;

    return-void
.end method

.method public a(Lcom/google/android/gms/common/data/DataHolder;)V
    .locals 2

    iget-object v0, p0, Lawd;->a:Latt;

    if-eqz v0, :cond_0

    :try_start_0
    iget-object v0, p0, Lawd;->a:Latt;

    new-instance v1, Latw;

    invoke-direct {v1, p1}, Latw;-><init>(Lcom/google/android/gms/common/data/DataHolder;)V

    invoke-interface {v0, v1}, Latt;->onDataChanged(Latw;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    invoke-virtual {p1}, Lcom/google/android/gms/common/data/DataHolder;->i()V

    :goto_0
    return-void

    :catchall_0
    move-exception v0

    invoke-virtual {p1}, Lcom/google/android/gms/common/data/DataHolder;->i()V

    throw v0

    :cond_0
    invoke-virtual {p1}, Lcom/google/android/gms/common/data/DataHolder;->i()V

    goto :goto_0
.end method

.method public a(Lcom/google/android/gms/wearable/internal/ai;)V
    .locals 1

    iget-object v0, p0, Lawd;->b:Lauc;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lawd;->b:Lauc;

    invoke-interface {v0, p1}, Lauc;->a(Laud;)V

    :cond_0
    return-void
.end method

.method public a(Lcom/google/android/gms/wearable/internal/al;)V
    .locals 1

    iget-object v0, p0, Lawd;->c:Lauh;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lawd;->c:Lauh;

    invoke-interface {v0, p1}, Lauh;->a(Laue;)V

    :cond_0
    return-void
.end method

.method public b(Lcom/google/android/gms/wearable/internal/al;)V
    .locals 1

    iget-object v0, p0, Lawd;->c:Lauh;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lawd;->c:Lauh;

    invoke-interface {v0, p1}, Lauh;->b(Laue;)V

    :cond_0
    return-void
.end method

.method public b()[Landroid/content/IntentFilter;
    .locals 1

    iget-object v0, p0, Lawd;->d:[Landroid/content/IntentFilter;

    return-object v0
.end method
