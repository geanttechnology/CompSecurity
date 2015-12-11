.class public final enum Lcom/amazon/retailsearch/metrics/ProgramName;
.super Ljava/lang/Enum;
.source "ProgramName.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/retailsearch/metrics/ProgramName;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/retailsearch/metrics/ProgramName;

.field public static final enum ANDROID:Lcom/amazon/retailsearch/metrics/ProgramName;

.field public static final enum DUKE:Lcom/amazon/retailsearch/metrics/ProgramName;

.field public static final enum KINDLE:Lcom/amazon/retailsearch/metrics/ProgramName;

.field public static final enum KINDLE_LEGACY:Lcom/amazon/retailsearch/metrics/ProgramName;

.field public static final enum TABLET:Lcom/amazon/retailsearch/metrics/ProgramName;

.field private static final log:Lcom/amazon/retailsearch/log/MessageLogger;


# instance fields
.field private browseProgramName:Ljava/lang/String;

.field private issProgramName:Ljava/lang/String;

.field private searchProgramName:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 13

    .prologue
    const/4 v12, 0x4

    const/4 v11, 0x3

    const/4 v10, 0x2

    const/4 v9, 0x1

    const/4 v2, 0x0

    .line 15
    new-instance v0, Lcom/amazon/retailsearch/metrics/ProgramName;

    const-string/jumbo v1, "ANDROID"

    const-string/jumbo v3, "MShopAndroidSearch"

    const-string/jumbo v4, "MShopAndroidISS"

    const-string/jumbo v5, "MShopAndroidBrowse"

    invoke-direct/range {v0 .. v5}, Lcom/amazon/retailsearch/metrics/ProgramName;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/ProgramName;->ANDROID:Lcom/amazon/retailsearch/metrics/ProgramName;

    .line 16
    new-instance v3, Lcom/amazon/retailsearch/metrics/ProgramName;

    const-string/jumbo v4, "KINDLE_LEGACY"

    const-string/jumbo v6, "MShopKindleLegacySearch"

    const-string/jumbo v7, "MShopKindleLegacyISS"

    const-string/jumbo v8, "MShopKindleLegacyBrowse"

    move v5, v9

    invoke-direct/range {v3 .. v8}, Lcom/amazon/retailsearch/metrics/ProgramName;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/retailsearch/metrics/ProgramName;->KINDLE_LEGACY:Lcom/amazon/retailsearch/metrics/ProgramName;

    .line 17
    new-instance v3, Lcom/amazon/retailsearch/metrics/ProgramName;

    const-string/jumbo v4, "KINDLE"

    const-string/jumbo v6, "MShopKindleSearch"

    const-string/jumbo v7, "MShopKindleISS"

    const-string/jumbo v8, "MShopKindleBrowse"

    move v5, v10

    invoke-direct/range {v3 .. v8}, Lcom/amazon/retailsearch/metrics/ProgramName;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/retailsearch/metrics/ProgramName;->KINDLE:Lcom/amazon/retailsearch/metrics/ProgramName;

    .line 18
    new-instance v3, Lcom/amazon/retailsearch/metrics/ProgramName;

    const-string/jumbo v4, "TABLET"

    const-string/jumbo v6, "MShopTabletSearch"

    const-string/jumbo v7, "MShopTabletISS"

    const-string/jumbo v8, "MShopTabletBrowse"

    move v5, v11

    invoke-direct/range {v3 .. v8}, Lcom/amazon/retailsearch/metrics/ProgramName;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/retailsearch/metrics/ProgramName;->TABLET:Lcom/amazon/retailsearch/metrics/ProgramName;

    .line 19
    new-instance v3, Lcom/amazon/retailsearch/metrics/ProgramName;

    const-string/jumbo v4, "DUKE"

    const-string/jumbo v6, "MShopDukeSearch"

    const-string/jumbo v7, "MShopDukeISS"

    const-string/jumbo v8, "MShopDukeBrowse"

    move v5, v12

    invoke-direct/range {v3 .. v8}, Lcom/amazon/retailsearch/metrics/ProgramName;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/retailsearch/metrics/ProgramName;->DUKE:Lcom/amazon/retailsearch/metrics/ProgramName;

    .line 11
    const/4 v0, 0x5

    new-array v0, v0, [Lcom/amazon/retailsearch/metrics/ProgramName;

    sget-object v1, Lcom/amazon/retailsearch/metrics/ProgramName;->ANDROID:Lcom/amazon/retailsearch/metrics/ProgramName;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/retailsearch/metrics/ProgramName;->KINDLE_LEGACY:Lcom/amazon/retailsearch/metrics/ProgramName;

    aput-object v1, v0, v9

    sget-object v1, Lcom/amazon/retailsearch/metrics/ProgramName;->KINDLE:Lcom/amazon/retailsearch/metrics/ProgramName;

    aput-object v1, v0, v10

    sget-object v1, Lcom/amazon/retailsearch/metrics/ProgramName;->TABLET:Lcom/amazon/retailsearch/metrics/ProgramName;

    aput-object v1, v0, v11

    sget-object v1, Lcom/amazon/retailsearch/metrics/ProgramName;->DUKE:Lcom/amazon/retailsearch/metrics/ProgramName;

    aput-object v1, v0, v12

    sput-object v0, Lcom/amazon/retailsearch/metrics/ProgramName;->$VALUES:[Lcom/amazon/retailsearch/metrics/ProgramName;

    .line 25
    const-class v0, Lcom/amazon/retailsearch/metrics/ProgramName;

    invoke-static {v0}, Lcom/amazon/retailsearch/log/AppLog;->getLog(Ljava/lang/Class;)Lcom/amazon/retailsearch/log/MessageLogger;

    move-result-object v0

    sput-object v0, Lcom/amazon/retailsearch/metrics/ProgramName;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p3, "searchProgramName"    # Ljava/lang/String;
    .param p4, "issProgramName"    # Ljava/lang/String;
    .param p5, "browseProgramName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 28
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 29
    iput-object p3, p0, Lcom/amazon/retailsearch/metrics/ProgramName;->searchProgramName:Ljava/lang/String;

    .line 30
    iput-object p4, p0, Lcom/amazon/retailsearch/metrics/ProgramName;->issProgramName:Ljava/lang/String;

    .line 31
    iput-object p5, p0, Lcom/amazon/retailsearch/metrics/ProgramName;->browseProgramName:Ljava/lang/String;

    .line 32
    return-void
.end method

.method public static getProgramName(Ljava/lang/String;)Lcom/amazon/retailsearch/metrics/ProgramName;
    .locals 5
    .param p0, "fromString"    # Ljava/lang/String;

    .prologue
    .line 55
    :try_start_0
    invoke-static {p0}, Lcom/amazon/retailsearch/metrics/ProgramName;->valueOf(Ljava/lang/String;)Lcom/amazon/retailsearch/metrics/ProgramName;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 63
    .local v1, "result":Lcom/amazon/retailsearch/metrics/ProgramName;
    :goto_0
    return-object v1

    .line 57
    .end local v1    # "result":Lcom/amazon/retailsearch/metrics/ProgramName;
    :catch_0
    move-exception v0

    .line 59
    .local v0, "e":Ljava/lang/Exception;
    sget-object v1, Lcom/amazon/retailsearch/metrics/ProgramName;->ANDROID:Lcom/amazon/retailsearch/metrics/ProgramName;

    .line 60
    .restart local v1    # "result":Lcom/amazon/retailsearch/metrics/ProgramName;
    sget-object v2, Lcom/amazon/retailsearch/metrics/ProgramName;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "Invalid program name configured. Defaulting to "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v1}, Lcom/amazon/retailsearch/metrics/ProgramName;->getSearchProgramName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Lcom/amazon/retailsearch/log/MessageLogger;->warn(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/retailsearch/metrics/ProgramName;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 11
    const-class v0, Lcom/amazon/retailsearch/metrics/ProgramName;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/metrics/ProgramName;

    return-object v0
.end method

.method public static values()[Lcom/amazon/retailsearch/metrics/ProgramName;
    .locals 1

    .prologue
    .line 11
    sget-object v0, Lcom/amazon/retailsearch/metrics/ProgramName;->$VALUES:[Lcom/amazon/retailsearch/metrics/ProgramName;

    invoke-virtual {v0}, [Lcom/amazon/retailsearch/metrics/ProgramName;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/retailsearch/metrics/ProgramName;

    return-object v0
.end method


# virtual methods
.method public getBrowseProgramName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/ProgramName;->browseProgramName:Ljava/lang/String;

    return-object v0
.end method

.method public getIssProgramName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/ProgramName;->issProgramName:Ljava/lang/String;

    return-object v0
.end method

.method public getSearchProgramName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/ProgramName;->searchProgramName:Ljava/lang/String;

    return-object v0
.end method
