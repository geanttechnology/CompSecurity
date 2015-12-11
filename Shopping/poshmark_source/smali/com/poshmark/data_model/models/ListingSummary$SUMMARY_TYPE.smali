.class public final enum Lcom/poshmark/data_model/models/ListingSummary$SUMMARY_TYPE;
.super Ljava/lang/Enum;
.source "ListingSummary.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/data_model/models/ListingSummary;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "SUMMARY_TYPE"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/poshmark/data_model/models/ListingSummary$SUMMARY_TYPE;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/poshmark/data_model/models/ListingSummary$SUMMARY_TYPE;

.field public static final enum DEFAULT:Lcom/poshmark/data_model/models/ListingSummary$SUMMARY_TYPE;

.field public static final enum SOCIAL_OLDEST:Lcom/poshmark/data_model/models/ListingSummary$SUMMARY_TYPE;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 50
    new-instance v0, Lcom/poshmark/data_model/models/ListingSummary$SUMMARY_TYPE;

    const-string v1, "DEFAULT"

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/ListingSummary$SUMMARY_TYPE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/ListingSummary$SUMMARY_TYPE;->DEFAULT:Lcom/poshmark/data_model/models/ListingSummary$SUMMARY_TYPE;

    .line 51
    new-instance v0, Lcom/poshmark/data_model/models/ListingSummary$SUMMARY_TYPE;

    const-string v1, "SOCIAL_OLDEST"

    invoke-direct {v0, v1, v3}, Lcom/poshmark/data_model/models/ListingSummary$SUMMARY_TYPE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/ListingSummary$SUMMARY_TYPE;->SOCIAL_OLDEST:Lcom/poshmark/data_model/models/ListingSummary$SUMMARY_TYPE;

    .line 49
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/poshmark/data_model/models/ListingSummary$SUMMARY_TYPE;

    sget-object v1, Lcom/poshmark/data_model/models/ListingSummary$SUMMARY_TYPE;->DEFAULT:Lcom/poshmark/data_model/models/ListingSummary$SUMMARY_TYPE;

    aput-object v1, v0, v2

    sget-object v1, Lcom/poshmark/data_model/models/ListingSummary$SUMMARY_TYPE;->SOCIAL_OLDEST:Lcom/poshmark/data_model/models/ListingSummary$SUMMARY_TYPE;

    aput-object v1, v0, v3

    sput-object v0, Lcom/poshmark/data_model/models/ListingSummary$SUMMARY_TYPE;->$VALUES:[Lcom/poshmark/data_model/models/ListingSummary$SUMMARY_TYPE;

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
    .line 49
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/poshmark/data_model/models/ListingSummary$SUMMARY_TYPE;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 49
    const-class v0, Lcom/poshmark/data_model/models/ListingSummary$SUMMARY_TYPE;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/ListingSummary$SUMMARY_TYPE;

    return-object v0
.end method

.method public static values()[Lcom/poshmark/data_model/models/ListingSummary$SUMMARY_TYPE;
    .locals 1

    .prologue
    .line 49
    sget-object v0, Lcom/poshmark/data_model/models/ListingSummary$SUMMARY_TYPE;->$VALUES:[Lcom/poshmark/data_model/models/ListingSummary$SUMMARY_TYPE;

    invoke-virtual {v0}, [Lcom/poshmark/data_model/models/ListingSummary$SUMMARY_TYPE;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/poshmark/data_model/models/ListingSummary$SUMMARY_TYPE;

    return-object v0
.end method
