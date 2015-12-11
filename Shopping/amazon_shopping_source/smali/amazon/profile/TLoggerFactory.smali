.class public Lamazon/profile/TLoggerFactory;
.super Ljava/lang/Object;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getLogger(Ljava/lang/String;)Lamazon/profile/TLogger;
    .locals 2

    const-string/jumbo v0, "BogusTLoggerFactory"

    const-string/jumbo v1, "getLogger"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    new-instance v0, Lamazon/profile/TLogger;

    invoke-direct {v0}, Lamazon/profile/TLogger;-><init>()V

    return-object v0
.end method
