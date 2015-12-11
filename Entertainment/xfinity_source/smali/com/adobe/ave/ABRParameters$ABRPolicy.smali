.class public final enum Lcom/adobe/ave/ABRParameters$ABRPolicy;
.super Ljava/lang/Enum;
.source "ABRParameters.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/ave/ABRParameters;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "ABRPolicy"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/adobe/ave/ABRParameters$ABRPolicy;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/adobe/ave/ABRParameters$ABRPolicy;

.field public static final enum ABR_AGGRESSIVE:Lcom/adobe/ave/ABRParameters$ABRPolicy;

.field public static final enum ABR_AUTO_OFF:Lcom/adobe/ave/ABRParameters$ABRPolicy;

.field public static final enum ABR_CONSERVATIVE:Lcom/adobe/ave/ABRParameters$ABRPolicy;

.field public static final enum ABR_MODERATE:Lcom/adobe/ave/ABRParameters$ABRPolicy;


# instance fields
.field private final value:I


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 34
    new-instance v0, Lcom/adobe/ave/ABRParameters$ABRPolicy;

    const-string v1, "ABR_AGGRESSIVE"

    invoke-direct {v0, v1, v2, v2}, Lcom/adobe/ave/ABRParameters$ABRPolicy;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/ABRParameters$ABRPolicy;->ABR_AGGRESSIVE:Lcom/adobe/ave/ABRParameters$ABRPolicy;

    .line 39
    new-instance v0, Lcom/adobe/ave/ABRParameters$ABRPolicy;

    const-string v1, "ABR_MODERATE"

    invoke-direct {v0, v1, v3, v3}, Lcom/adobe/ave/ABRParameters$ABRPolicy;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/ABRParameters$ABRPolicy;->ABR_MODERATE:Lcom/adobe/ave/ABRParameters$ABRPolicy;

    .line 44
    new-instance v0, Lcom/adobe/ave/ABRParameters$ABRPolicy;

    const-string v1, "ABR_CONSERVATIVE"

    invoke-direct {v0, v1, v4, v4}, Lcom/adobe/ave/ABRParameters$ABRPolicy;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/ABRParameters$ABRPolicy;->ABR_CONSERVATIVE:Lcom/adobe/ave/ABRParameters$ABRPolicy;

    .line 50
    new-instance v0, Lcom/adobe/ave/ABRParameters$ABRPolicy;

    const-string v1, "ABR_AUTO_OFF"

    invoke-direct {v0, v1, v5, v5}, Lcom/adobe/ave/ABRParameters$ABRPolicy;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/ABRParameters$ABRPolicy;->ABR_AUTO_OFF:Lcom/adobe/ave/ABRParameters$ABRPolicy;

    .line 29
    const/4 v0, 0x4

    new-array v0, v0, [Lcom/adobe/ave/ABRParameters$ABRPolicy;

    sget-object v1, Lcom/adobe/ave/ABRParameters$ABRPolicy;->ABR_AGGRESSIVE:Lcom/adobe/ave/ABRParameters$ABRPolicy;

    aput-object v1, v0, v2

    sget-object v1, Lcom/adobe/ave/ABRParameters$ABRPolicy;->ABR_MODERATE:Lcom/adobe/ave/ABRParameters$ABRPolicy;

    aput-object v1, v0, v3

    sget-object v1, Lcom/adobe/ave/ABRParameters$ABRPolicy;->ABR_CONSERVATIVE:Lcom/adobe/ave/ABRParameters$ABRPolicy;

    aput-object v1, v0, v4

    sget-object v1, Lcom/adobe/ave/ABRParameters$ABRPolicy;->ABR_AUTO_OFF:Lcom/adobe/ave/ABRParameters$ABRPolicy;

    aput-object v1, v0, v5

    sput-object v0, Lcom/adobe/ave/ABRParameters$ABRPolicy;->$VALUES:[Lcom/adobe/ave/ABRParameters$ABRPolicy;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;II)V
    .locals 0
    .param p3, "val"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)V"
        }
    .end annotation

    .prologue
    .line 59
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 60
    iput p3, p0, Lcom/adobe/ave/ABRParameters$ABRPolicy;->value:I

    .line 61
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/adobe/ave/ABRParameters$ABRPolicy;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 29
    const-class v0, Lcom/adobe/ave/ABRParameters$ABRPolicy;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/adobe/ave/ABRParameters$ABRPolicy;

    return-object v0
.end method

.method public static values()[Lcom/adobe/ave/ABRParameters$ABRPolicy;
    .locals 1

    .prologue
    .line 29
    sget-object v0, Lcom/adobe/ave/ABRParameters$ABRPolicy;->$VALUES:[Lcom/adobe/ave/ABRParameters$ABRPolicy;

    invoke-virtual {v0}, [Lcom/adobe/ave/ABRParameters$ABRPolicy;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/adobe/ave/ABRParameters$ABRPolicy;

    return-object v0
.end method


# virtual methods
.method public getValue()I
    .locals 1

    .prologue
    .line 67
    iget v0, p0, Lcom/adobe/ave/ABRParameters$ABRPolicy;->value:I

    return v0
.end method
