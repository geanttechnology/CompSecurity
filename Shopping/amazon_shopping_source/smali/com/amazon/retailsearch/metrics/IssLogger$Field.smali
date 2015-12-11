.class public final enum Lcom/amazon/retailsearch/metrics/IssLogger$Field;
.super Ljava/lang/Enum;
.source "IssLogger.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/metrics/IssLogger;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "Field"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/retailsearch/metrics/IssLogger$Field;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/retailsearch/metrics/IssLogger$Field;

.field public static final enum DataSet:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

.field public static final enum IsFallback:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

.field public static final enum IsMidquery:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

.field public static final enum IsNonPrefix:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

.field public static final enum IsRobot:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

.field public static final enum IsSpellCorrected:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

.field public static final enum IsXcat:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

.field public static final enum Marketplace:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

.field public static final enum Pos:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

.field public static final enum Prefix:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

.field public static final enum RequestId:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

.field public static final enum ServiceName:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

.field public static final enum Size:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

.field public static final enum Source:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

.field public static final enum SourceSearchAlias:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

.field public static final enum Suffix:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

.field public static final enum Suggestion:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

.field public static final enum TargetSearchAlias:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

.field public static final enum UserAction:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

.field public static final enum Weblabs:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

.field public static final enum XcatPos:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

.field public static final enum XcatSize:Lcom/amazon/retailsearch/metrics/IssLogger$Field;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 34
    new-instance v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    const-string/jumbo v1, "DataSet"

    invoke-direct {v0, v1, v3}, Lcom/amazon/retailsearch/metrics/IssLogger$Field;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->DataSet:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    .line 35
    new-instance v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    const-string/jumbo v1, "Marketplace"

    invoke-direct {v0, v1, v4}, Lcom/amazon/retailsearch/metrics/IssLogger$Field;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->Marketplace:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    .line 36
    new-instance v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    const-string/jumbo v1, "SourceSearchAlias"

    invoke-direct {v0, v1, v5}, Lcom/amazon/retailsearch/metrics/IssLogger$Field;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->SourceSearchAlias:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    .line 37
    new-instance v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    const-string/jumbo v1, "TargetSearchAlias"

    invoke-direct {v0, v1, v6}, Lcom/amazon/retailsearch/metrics/IssLogger$Field;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->TargetSearchAlias:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    .line 38
    new-instance v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    const-string/jumbo v1, "ServiceName"

    invoke-direct {v0, v1, v7}, Lcom/amazon/retailsearch/metrics/IssLogger$Field;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->ServiceName:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    .line 39
    new-instance v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    const-string/jumbo v1, "Source"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/IssLogger$Field;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->Source:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    .line 40
    new-instance v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    const-string/jumbo v1, "UserAction"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/IssLogger$Field;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->UserAction:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    .line 41
    new-instance v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    const-string/jumbo v1, "Pos"

    const/4 v2, 0x7

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/IssLogger$Field;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->Pos:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    .line 42
    new-instance v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    const-string/jumbo v1, "XcatPos"

    const/16 v2, 0x8

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/IssLogger$Field;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->XcatPos:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    .line 43
    new-instance v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    const-string/jumbo v1, "Size"

    const/16 v2, 0x9

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/IssLogger$Field;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->Size:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    .line 44
    new-instance v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    const-string/jumbo v1, "XcatSize"

    const/16 v2, 0xa

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/IssLogger$Field;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->XcatSize:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    .line 45
    new-instance v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    const-string/jumbo v1, "IsSpellCorrected"

    const/16 v2, 0xb

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/IssLogger$Field;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->IsSpellCorrected:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    .line 46
    new-instance v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    const-string/jumbo v1, "IsXcat"

    const/16 v2, 0xc

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/IssLogger$Field;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->IsXcat:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    .line 47
    new-instance v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    const-string/jumbo v1, "IsFallback"

    const/16 v2, 0xd

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/IssLogger$Field;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->IsFallback:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    .line 48
    new-instance v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    const-string/jumbo v1, "IsMidquery"

    const/16 v2, 0xe

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/IssLogger$Field;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->IsMidquery:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    .line 49
    new-instance v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    const-string/jumbo v1, "IsNonPrefix"

    const/16 v2, 0xf

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/IssLogger$Field;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->IsNonPrefix:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    .line 50
    new-instance v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    const-string/jumbo v1, "IsRobot"

    const/16 v2, 0x10

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/IssLogger$Field;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->IsRobot:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    .line 51
    new-instance v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    const-string/jumbo v1, "Weblabs"

    const/16 v2, 0x11

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/IssLogger$Field;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->Weblabs:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    .line 52
    new-instance v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    const-string/jumbo v1, "Prefix"

    const/16 v2, 0x12

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/IssLogger$Field;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->Prefix:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    .line 53
    new-instance v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    const-string/jumbo v1, "Suffix"

    const/16 v2, 0x13

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/IssLogger$Field;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->Suffix:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    .line 54
    new-instance v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    const-string/jumbo v1, "Suggestion"

    const/16 v2, 0x14

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/IssLogger$Field;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->Suggestion:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    .line 55
    new-instance v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    const-string/jumbo v1, "RequestId"

    const/16 v2, 0x15

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/IssLogger$Field;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->RequestId:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    .line 32
    const/16 v0, 0x16

    new-array v0, v0, [Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    sget-object v1, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->DataSet:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->Marketplace:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->SourceSearchAlias:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->TargetSearchAlias:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    aput-object v1, v0, v6

    sget-object v1, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->ServiceName:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->Source:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->UserAction:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->Pos:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->XcatPos:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->Size:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->XcatSize:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->IsSpellCorrected:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    aput-object v2, v0, v1

    const/16 v1, 0xc

    sget-object v2, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->IsXcat:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    aput-object v2, v0, v1

    const/16 v1, 0xd

    sget-object v2, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->IsFallback:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    aput-object v2, v0, v1

    const/16 v1, 0xe

    sget-object v2, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->IsMidquery:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    aput-object v2, v0, v1

    const/16 v1, 0xf

    sget-object v2, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->IsNonPrefix:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    aput-object v2, v0, v1

    const/16 v1, 0x10

    sget-object v2, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->IsRobot:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    aput-object v2, v0, v1

    const/16 v1, 0x11

    sget-object v2, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->Weblabs:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    aput-object v2, v0, v1

    const/16 v1, 0x12

    sget-object v2, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->Prefix:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    aput-object v2, v0, v1

    const/16 v1, 0x13

    sget-object v2, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->Suffix:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    aput-object v2, v0, v1

    const/16 v1, 0x14

    sget-object v2, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->Suggestion:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    aput-object v2, v0, v1

    const/16 v1, 0x15

    sget-object v2, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->RequestId:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->$VALUES:[Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 32
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/retailsearch/metrics/IssLogger$Field;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 32
    const-class v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    return-object v0
.end method

.method public static values()[Lcom/amazon/retailsearch/metrics/IssLogger$Field;
    .locals 1

    .prologue
    .line 32
    sget-object v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->$VALUES:[Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    invoke-virtual {v0}, [Lcom/amazon/retailsearch/metrics/IssLogger$Field;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    return-object v0
.end method
