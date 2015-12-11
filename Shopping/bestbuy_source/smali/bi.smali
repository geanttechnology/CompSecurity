.class final Lbi;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private a:Lag;

.field private b:Lao;

.field private c:Ljava/lang/String;

.field private d:I

.field private final e:Ljava/util/LinkedList;


# direct methods
.method constructor <init>()V
    .locals 1

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    const/4 v0, 0x0

    iput-object v0, p0, Lbi;->c:Ljava/lang/String;

    .line 21
    const/4 v0, 0x0

    iput v0, p0, Lbi;->d:I

    .line 22
    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    iput-object v0, p0, Lbi;->e:Ljava/util/LinkedList;

    .line 24
    return-void
.end method

.method private a(Ljava/lang/String;Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 91
    new-instance v0, Lbj;

    invoke-direct {v0, p1, p2}, Lbj;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 93
    iget-object v1, p0, Lbi;->e:Ljava/util/LinkedList;

    monitor-enter v1

    .line 94
    :try_start_0
    iget-object v2, p0, Lbi;->a:Lag;

    if-eqz v2, :cond_0

    iget-object v2, p0, Lbi;->b:Lao;

    if-nez v2, :cond_2

    .line 95
    :cond_0
    iget-object v2, p0, Lbi;->e:Ljava/util/LinkedList;

    invoke-virtual {v2}, Ljava/util/LinkedList;->size()I

    move-result v2

    const/16 v3, 0xa

    if-ge v2, v3, :cond_1

    .line 96
    iget-object v2, p0, Lbi;->e:Ljava/util/LinkedList;

    invoke-virtual {v2, v0}, Ljava/util/LinkedList;->add(Ljava/lang/Object;)Z

    .line 102
    :cond_1
    :goto_0
    monitor-exit v1

    return-void

    .line 99
    :cond_2
    iget-object v2, p0, Lbi;->a:Lag;

    invoke-virtual {v2, v0}, Lag;->a(Lbj;)Lorg/json/JSONObject;

    move-result-object v0

    .line 100
    if-eqz v0, :cond_1

    iget-object v2, p0, Lbi;->b:Lao;

    invoke-virtual {v2, v0}, Lao;->b(Lorg/json/JSONObject;)V

    goto :goto_0

    .line 102
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method private static d(Landroid/app/Activity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 116
    if-nez p0, :cond_0

    .line 117
    const-string v0, "null"

    .line 119
    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method


# virtual methods
.method final a(Lag;Lao;)V
    .locals 5

    .prologue
    .line 37
    iget-object v1, p0, Lbi;->e:Ljava/util/LinkedList;

    monitor-enter v1

    .line 41
    :try_start_0
    iput-object p1, p0, Lbi;->a:Lag;

    .line 42
    iput-object p2, p0, Lbi;->b:Lao;

    .line 44
    iget-object v2, p0, Lbi;->e:Ljava/util/LinkedList;

    monitor-enter v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    :try_start_1
    iget-object v0, p0, Lbi;->e:Ljava/util/LinkedList;

    invoke-virtual {v0}, Ljava/util/LinkedList;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_0
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lbj;

    iget-object v4, p0, Lbi;->a:Lag;

    invoke-virtual {v4, v0}, Lag;->a(Lbj;)Lorg/json/JSONObject;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v4, p0, Lbi;->b:Lao;

    invoke-virtual {v4, v0}, Lao;->b(Lorg/json/JSONObject;)V

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :try_start_2
    throw v0

    .line 45
    :catchall_1
    move-exception v0

    monitor-exit v1
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    throw v0

    .line 44
    :cond_1
    :try_start_3
    monitor-exit v2
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 45
    :try_start_4
    monitor-exit v1
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    return-void
.end method

.method final a(Landroid/app/Activity;)V
    .locals 2

    .prologue
    .line 55
    iget v0, p0, Lbi;->d:I

    if-nez v0, :cond_0

    .line 56
    const-string v0, "Lifecycle: App Start"

    invoke-static {v0}, Lbc;->a(Ljava/lang/String;)V

    .line 57
    invoke-static {p1}, Lbi;->d(Landroid/app/Activity;)Ljava/lang/String;

    move-result-object v0

    .line 58
    const-string v1, "App Start"

    invoke-direct {p0, v0, v1}, Lbi;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 59
    iput-object v0, p0, Lbi;->c:Ljava/lang/String;

    .line 62
    :cond_0
    iget v0, p0, Lbi;->d:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lbi;->d:I

    .line 63
    return-void
.end method

.method final b(Landroid/app/Activity;)V
    .locals 2

    .prologue
    .line 66
    iget v0, p0, Lbi;->d:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Lbi;->d:I

    .line 68
    iget v0, p0, Lbi;->d:I

    if-nez v0, :cond_0

    .line 69
    const-string v0, "Lifecycle: App Stop"

    invoke-static {v0}, Lbc;->a(Ljava/lang/String;)V

    .line 70
    invoke-static {p1}, Lbi;->d(Landroid/app/Activity;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "App Stop"

    invoke-direct {p0, v0, v1}, Lbi;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 71
    const/4 v0, 0x0

    iput-object v0, p0, Lbi;->c:Ljava/lang/String;

    .line 73
    :cond_0
    return-void
.end method

.method final c(Landroid/app/Activity;)V
    .locals 2

    .prologue
    .line 76
    invoke-static {p1}, Lbi;->d(Landroid/app/Activity;)Ljava/lang/String;

    move-result-object v0

    .line 77
    iget-object v1, p0, Lbi;->c:Ljava/lang/String;

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 79
    const-string v1, "Lifecycle: Activity Change"

    invoke-static {v1}, Lbc;->a(Ljava/lang/String;)V

    .line 80
    const-string v1, "Activity Change"

    invoke-direct {p0, v0, v1}, Lbi;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 81
    iput-object v0, p0, Lbi;->c:Ljava/lang/String;

    .line 83
    :cond_0
    return-void
.end method
