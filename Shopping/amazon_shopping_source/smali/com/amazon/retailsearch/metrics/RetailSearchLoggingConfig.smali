.class public Lcom/amazon/retailsearch/metrics/RetailSearchLoggingConfig;
.super Ljava/lang/Object;
.source "RetailSearchLoggingConfig.java"


# static fields
.field static final TAG:Ljava/lang/String;


# instance fields
.field private browseProgramName:Ljava/lang/String;

.field private enableLogging:Z

.field private issProgramName:Ljava/lang/String;

.field private searchProgramName:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 16
    const-class v0, Lcom/amazon/retailsearch/metrics/RetailSearchLoggingConfig;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/retailsearch/metrics/RetailSearchLoggingConfig;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 5
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    const/4 v4, 0x0

    iput-boolean v4, p0, Lcom/amazon/retailsearch/metrics/RetailSearchLoggingConfig;->enableLogging:Z

    .line 20
    sget-object v4, Lcom/amazon/retailsearch/metrics/ProgramName;->ANDROID:Lcom/amazon/retailsearch/metrics/ProgramName;

    invoke-virtual {v4}, Lcom/amazon/retailsearch/metrics/ProgramName;->getSearchProgramName()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/retailsearch/metrics/RetailSearchLoggingConfig;->searchProgramName:Ljava/lang/String;

    .line 21
    sget-object v4, Lcom/amazon/retailsearch/metrics/ProgramName;->ANDROID:Lcom/amazon/retailsearch/metrics/ProgramName;

    invoke-virtual {v4}, Lcom/amazon/retailsearch/metrics/ProgramName;->getIssProgramName()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/retailsearch/metrics/RetailSearchLoggingConfig;->issProgramName:Ljava/lang/String;

    .line 22
    sget-object v4, Lcom/amazon/retailsearch/metrics/ProgramName;->ANDROID:Lcom/amazon/retailsearch/metrics/ProgramName;

    invoke-virtual {v4}, Lcom/amazon/retailsearch/metrics/ProgramName;->getBrowseProgramName()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/retailsearch/metrics/RetailSearchLoggingConfig;->browseProgramName:Ljava/lang/String;

    .line 26
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    .line 27
    .local v2, "res":Landroid/content/res/Resources;
    sget v4, Lcom/amazon/retailsearch/R$string;->config_rs_enable_logging:I

    invoke-virtual {v2, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 28
    .local v1, "configValue":Ljava/lang/String;
    const-string/jumbo v4, "true"

    invoke-virtual {v4, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    iput-boolean v4, p0, Lcom/amazon/retailsearch/metrics/RetailSearchLoggingConfig;->enableLogging:Z

    .line 30
    sget v4, Lcom/amazon/retailsearch/R$string;->config_rs_logging_program_name:I

    invoke-virtual {v2, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 31
    .local v0, "configProgramName":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/retailsearch/metrics/ProgramName;->getProgramName(Ljava/lang/String;)Lcom/amazon/retailsearch/metrics/ProgramName;

    move-result-object v3

    .line 32
    .local v3, "validProgramName":Lcom/amazon/retailsearch/metrics/ProgramName;
    invoke-virtual {v3}, Lcom/amazon/retailsearch/metrics/ProgramName;->getSearchProgramName()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/retailsearch/metrics/RetailSearchLoggingConfig;->searchProgramName:Ljava/lang/String;

    .line 33
    invoke-virtual {v3}, Lcom/amazon/retailsearch/metrics/ProgramName;->getIssProgramName()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/retailsearch/metrics/RetailSearchLoggingConfig;->issProgramName:Ljava/lang/String;

    .line 34
    invoke-virtual {v3}, Lcom/amazon/retailsearch/metrics/ProgramName;->getBrowseProgramName()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/retailsearch/metrics/RetailSearchLoggingConfig;->browseProgramName:Ljava/lang/String;

    .line 35
    return-void
.end method


# virtual methods
.method public getBrowseProgramName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 74
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchLoggingConfig;->browseProgramName:Ljava/lang/String;

    return-object v0
.end method

.method public getIssProgramName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 64
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchLoggingConfig;->issProgramName:Ljava/lang/String;

    return-object v0
.end method

.method public getSearchProgramName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchLoggingConfig;->searchProgramName:Ljava/lang/String;

    return-object v0
.end method

.method public isLoggingEnabled()Z
    .locals 1

    .prologue
    .line 44
    iget-boolean v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchLoggingConfig;->enableLogging:Z

    return v0
.end method
