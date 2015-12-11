.class final Lcom/amazon/sdk/availability/Stage;
.super Ljava/lang/Object;
.source "Stage.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/sdk/availability/Stage$Domain;
    }
.end annotation


# static fields
.field protected static final DOMAIN:Lcom/amazon/sdk/availability/Stage$Domain;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 26
    sget-object v0, Lcom/amazon/sdk/availability/Stage$Domain;->PROD:Lcom/amazon/sdk/availability/Stage$Domain;

    sput-object v0, Lcom/amazon/sdk/availability/Stage;->DOMAIN:Lcom/amazon/sdk/availability/Stage$Domain;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 53
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 54
    return-void
.end method

.method public static getDomain()Lcom/amazon/sdk/availability/Stage$Domain;
    .locals 3

    .prologue
    .line 33
    const-string/jumbo v2, "mas.availability.stage"

    invoke-static {v2}, Lcom/amazon/mas/client/SysPropHelper;->get(Ljava/lang/String;)Lcom/amazon/mas/client/SysPropHelper;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mas/client/SysPropHelper;->getValue()Ljava/lang/String;

    move-result-object v1

    .line 34
    .local v1, "sysProp":Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mas/util/StringUtils;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 36
    :try_start_0
    invoke-static {v1}, Lcom/amazon/sdk/availability/Stage$Domain;->valueOf(Ljava/lang/String;)Lcom/amazon/sdk/availability/Stage$Domain;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 41
    :goto_0
    return-object v2

    .line 37
    :catch_0
    move-exception v0

    .line 38
    .local v0, "ex":Ljava/lang/Exception;
    sget-object v2, Lcom/amazon/sdk/availability/Stage;->DOMAIN:Lcom/amazon/sdk/availability/Stage$Domain;

    goto :goto_0

    .line 41
    .end local v0    # "ex":Ljava/lang/Exception;
    :cond_0
    sget-object v2, Lcom/amazon/sdk/availability/Stage;->DOMAIN:Lcom/amazon/sdk/availability/Stage$Domain;

    goto :goto_0
.end method

.method public static isProduction()Z
    .locals 2

    .prologue
    .line 49
    invoke-static {}, Lcom/amazon/sdk/availability/Stage;->getDomain()Lcom/amazon/sdk/availability/Stage$Domain;

    move-result-object v0

    sget-object v1, Lcom/amazon/sdk/availability/Stage$Domain;->PROD:Lcom/amazon/sdk/availability/Stage$Domain;

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
