.class public Lcom/comscore/analytics/comScore;
.super Ljava/lang/Object;


# static fields
.field private static a:Lcom/comscore/analytics/Core;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Lcom/comscore/analytics/Core;

    invoke-direct {v0}, Lcom/comscore/analytics/Core;-><init>()V

    sput-object v0, Lcom/comscore/analytics/comScore;->a:Lcom/comscore/analytics/Core;

    return-void
.end method

.method public static getCore()Lcom/comscore/analytics/Core;
    .locals 1

    sget-object v0, Lcom/comscore/analytics/comScore;->a:Lcom/comscore/analytics/Core;

    return-object v0
.end method

.method public static onEnterForeground()V
    .locals 1

    sget-object v0, Lcom/comscore/analytics/comScore;->a:Lcom/comscore/analytics/Core;

    invoke-virtual {v0}, Lcom/comscore/analytics/Core;->onEnterForeground()V

    return-void
.end method

.method public static onExitForeground()V
    .locals 1

    sget-object v0, Lcom/comscore/analytics/comScore;->a:Lcom/comscore/analytics/Core;

    invoke-virtual {v0}, Lcom/comscore/analytics/Core;->onExitForeground()V

    return-void
.end method

.method public static setAppContext(Landroid/content/Context;)V
    .locals 1

    sget-object v0, Lcom/comscore/analytics/comScore;->a:Lcom/comscore/analytics/Core;

    invoke-virtual {v0, p0}, Lcom/comscore/analytics/Core;->setAppContext(Landroid/content/Context;)V

    return-void
.end method
