.class public Lpk;
.super Lpm;


# static fields
.field private static b:Lpk;


# instance fields
.field private a:Lpl;


# direct methods
.method static a()Lpk;
    .locals 2

    const-class v1, Lpk;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lpk;->b:Lpk;

    monitor-exit v1

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method


# virtual methods
.method public b()Lpl;
    .locals 1

    iget-object v0, p0, Lpk;->a:Lpl;

    return-object v0
.end method
