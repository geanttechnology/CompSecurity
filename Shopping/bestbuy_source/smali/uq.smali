.class public Luq;
.super Luv;

# interfaces
.implements Lut;


# annotations
.annotation runtime Lzf;
.end annotation


# instance fields
.field private final a:Ljava/lang/String;

.field private final b:Landroid/graphics/drawable/Drawable;

.field private final c:Ljava/lang/String;

.field private final d:Landroid/graphics/drawable/Drawable;

.field private final e:Ljava/lang/String;

.field private final f:D

.field private final g:Ljava/lang/String;

.field private final h:Ljava/lang/String;

.field private final i:Ljava/lang/Object;

.field private j:Lus;


# direct methods
.method public constructor <init>(Ljava/lang/String;Landroid/graphics/drawable/Drawable;Ljava/lang/String;Landroid/graphics/drawable/Drawable;Ljava/lang/String;DLjava/lang/String;Ljava/lang/String;)V
    .locals 2

    invoke-direct {p0}, Luv;-><init>()V

    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Luq;->i:Ljava/lang/Object;

    iput-object p1, p0, Luq;->a:Ljava/lang/String;

    iput-object p2, p0, Luq;->b:Landroid/graphics/drawable/Drawable;

    iput-object p3, p0, Luq;->c:Ljava/lang/String;

    iput-object p4, p0, Luq;->d:Landroid/graphics/drawable/Drawable;

    iput-object p5, p0, Luq;->e:Ljava/lang/String;

    iput-wide p6, p0, Luq;->f:D

    iput-object p8, p0, Luq;->g:Ljava/lang/String;

    iput-object p9, p0, Luq;->h:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Luq;->a:Ljava/lang/String;

    return-object v0
.end method

.method public a(I)V
    .locals 3

    iget-object v1, p0, Luq;->i:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget-object v0, p0, Luq;->j:Lus;

    if-nez v0, :cond_0

    const-string v0, "Attempt to perform click before app install ad initialized."

    invoke-static {v0}, Lacb;->b(Ljava/lang/String;)V

    monitor-exit v1

    :goto_0
    return-void

    :cond_0
    iget-object v0, p0, Luq;->j:Lus;

    const-string v2, "2"

    invoke-virtual {v0, v2, p1}, Lus;->a(Ljava/lang/String;I)V

    monitor-exit v1

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public a(Lus;)V
    .locals 2

    iget-object v1, p0, Luq;->i:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iput-object p1, p0, Luq;->j:Lus;

    monitor-exit v1

    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public b()Lry;
    .locals 1

    iget-object v0, p0, Luq;->b:Landroid/graphics/drawable/Drawable;

    invoke-static {v0}, Lsb;->a(Ljava/lang/Object;)Lry;

    move-result-object v0

    return-object v0
.end method

.method public c()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Luq;->c:Ljava/lang/String;

    return-object v0
.end method

.method public d()Lry;
    .locals 1

    iget-object v0, p0, Luq;->d:Landroid/graphics/drawable/Drawable;

    invoke-static {v0}, Lsb;->a(Ljava/lang/Object;)Lry;

    move-result-object v0

    return-object v0
.end method

.method public e()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Luq;->e:Ljava/lang/String;

    return-object v0
.end method

.method public f()D
    .locals 2

    iget-wide v0, p0, Luq;->f:D

    return-wide v0
.end method

.method public g()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Luq;->g:Ljava/lang/String;

    return-object v0
.end method

.method public h()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Luq;->h:Ljava/lang/String;

    return-object v0
.end method

.method public i()V
    .locals 2

    iget-object v1, p0, Luq;->i:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget-object v0, p0, Luq;->j:Lus;

    if-nez v0, :cond_0

    const-string v0, "Attempt to record impression before app install ad initialized."

    invoke-static {v0}, Lacb;->b(Ljava/lang/String;)V

    monitor-exit v1

    :goto_0
    return-void

    :cond_0
    iget-object v0, p0, Luq;->j:Lus;

    invoke-virtual {v0}, Lus;->a()V

    monitor-exit v1

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method
