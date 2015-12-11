.class public Lamazon/profile/TLogger;
.super Ljava/lang/Object;


# direct methods
.method constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public enableLog(Z)Lamazon/profile/TLogger;
    .locals 2

    const-string/jumbo v0, "BogusTLogger"

    const-string/jumbo v1, "enableLog"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    return-object p0
.end method

.method public enableTrapz(Z)Lamazon/profile/TLogger;
    .locals 2

    const-string/jumbo v0, "BogusTLogger"

    const-string/jumbo v1, "enableTrapz"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    return-object p0
.end method

.method public getTraceId(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    .locals 2

    const-string/jumbo v0, "BogusTLogger"

    const-string/jumbo v1, "getTraceId"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    const/4 v0, 0x0

    return v0
.end method

.method public l(III)V
    .locals 1

    const-string/jumbo v0, ""

    invoke-virtual {p0, p1, p2, p3, v0}, Lamazon/profile/TLogger;->l(IIILjava/lang/String;)V

    return-void
.end method

.method public l(IIILjava/lang/String;)V
    .locals 2

    const-string/jumbo v0, "BogusTLogger"

    const-string/jumbo v1, "l"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    return-void
.end method
