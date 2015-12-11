.class public final enum Lcom/comcast/cim/microdata/model/FormFieldType;
.super Ljava/lang/Enum;
.source "FormFieldType.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/comcast/cim/microdata/model/FormFieldType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/comcast/cim/microdata/model/FormFieldType;

.field public static final enum DATE:Lcom/comcast/cim/microdata/model/FormFieldType;

.field public static final enum DATETIME:Lcom/comcast/cim/microdata/model/FormFieldType;

.field public static final enum HIDDEN:Lcom/comcast/cim/microdata/model/FormFieldType;

.field public static final enum MULTISELECT:Lcom/comcast/cim/microdata/model/FormFieldType;

.field public static final enum NUMBER:Lcom/comcast/cim/microdata/model/FormFieldType;

.field public static final enum SELECT:Lcom/comcast/cim/microdata/model/FormFieldType;

.field public static final enum TEXT:Lcom/comcast/cim/microdata/model/FormFieldType;

.field public static final enum TIME:Lcom/comcast/cim/microdata/model/FormFieldType;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 8
    new-instance v0, Lcom/comcast/cim/microdata/model/FormFieldType;

    const-string v1, "TEXT"

    invoke-direct {v0, v1, v3}, Lcom/comcast/cim/microdata/model/FormFieldType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/cim/microdata/model/FormFieldType;->TEXT:Lcom/comcast/cim/microdata/model/FormFieldType;

    .line 9
    new-instance v0, Lcom/comcast/cim/microdata/model/FormFieldType;

    const-string v1, "SELECT"

    invoke-direct {v0, v1, v4}, Lcom/comcast/cim/microdata/model/FormFieldType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/cim/microdata/model/FormFieldType;->SELECT:Lcom/comcast/cim/microdata/model/FormFieldType;

    .line 10
    new-instance v0, Lcom/comcast/cim/microdata/model/FormFieldType;

    const-string v1, "MULTISELECT"

    invoke-direct {v0, v1, v5}, Lcom/comcast/cim/microdata/model/FormFieldType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/cim/microdata/model/FormFieldType;->MULTISELECT:Lcom/comcast/cim/microdata/model/FormFieldType;

    .line 11
    new-instance v0, Lcom/comcast/cim/microdata/model/FormFieldType;

    const-string v1, "HIDDEN"

    invoke-direct {v0, v1, v6}, Lcom/comcast/cim/microdata/model/FormFieldType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/cim/microdata/model/FormFieldType;->HIDDEN:Lcom/comcast/cim/microdata/model/FormFieldType;

    .line 12
    new-instance v0, Lcom/comcast/cim/microdata/model/FormFieldType;

    const-string v1, "NUMBER"

    invoke-direct {v0, v1, v7}, Lcom/comcast/cim/microdata/model/FormFieldType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/cim/microdata/model/FormFieldType;->NUMBER:Lcom/comcast/cim/microdata/model/FormFieldType;

    .line 13
    new-instance v0, Lcom/comcast/cim/microdata/model/FormFieldType;

    const-string v1, "DATE"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/comcast/cim/microdata/model/FormFieldType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/cim/microdata/model/FormFieldType;->DATE:Lcom/comcast/cim/microdata/model/FormFieldType;

    .line 14
    new-instance v0, Lcom/comcast/cim/microdata/model/FormFieldType;

    const-string v1, "TIME"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/comcast/cim/microdata/model/FormFieldType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/cim/microdata/model/FormFieldType;->TIME:Lcom/comcast/cim/microdata/model/FormFieldType;

    .line 15
    new-instance v0, Lcom/comcast/cim/microdata/model/FormFieldType;

    const-string v1, "DATETIME"

    const/4 v2, 0x7

    invoke-direct {v0, v1, v2}, Lcom/comcast/cim/microdata/model/FormFieldType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/cim/microdata/model/FormFieldType;->DATETIME:Lcom/comcast/cim/microdata/model/FormFieldType;

    .line 6
    const/16 v0, 0x8

    new-array v0, v0, [Lcom/comcast/cim/microdata/model/FormFieldType;

    sget-object v1, Lcom/comcast/cim/microdata/model/FormFieldType;->TEXT:Lcom/comcast/cim/microdata/model/FormFieldType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/comcast/cim/microdata/model/FormFieldType;->SELECT:Lcom/comcast/cim/microdata/model/FormFieldType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/comcast/cim/microdata/model/FormFieldType;->MULTISELECT:Lcom/comcast/cim/microdata/model/FormFieldType;

    aput-object v1, v0, v5

    sget-object v1, Lcom/comcast/cim/microdata/model/FormFieldType;->HIDDEN:Lcom/comcast/cim/microdata/model/FormFieldType;

    aput-object v1, v0, v6

    sget-object v1, Lcom/comcast/cim/microdata/model/FormFieldType;->NUMBER:Lcom/comcast/cim/microdata/model/FormFieldType;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/comcast/cim/microdata/model/FormFieldType;->DATE:Lcom/comcast/cim/microdata/model/FormFieldType;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/comcast/cim/microdata/model/FormFieldType;->TIME:Lcom/comcast/cim/microdata/model/FormFieldType;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/comcast/cim/microdata/model/FormFieldType;->DATETIME:Lcom/comcast/cim/microdata/model/FormFieldType;

    aput-object v2, v0, v1

    sput-object v0, Lcom/comcast/cim/microdata/model/FormFieldType;->$VALUES:[Lcom/comcast/cim/microdata/model/FormFieldType;

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
    .line 6
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static parseType(Ljava/lang/String;)Lcom/comcast/cim/microdata/model/FormFieldType;
    .locals 3
    .param p0, "type"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    .line 27
    if-nez p0, :cond_0

    .line 34
    :goto_0
    return-object v1

    .line 32
    :cond_0
    :try_start_0
    invoke-virtual {p0}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/comcast/cim/microdata/model/FormFieldType;->valueOf(Ljava/lang/String;)Lcom/comcast/cim/microdata/model/FormFieldType;
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    goto :goto_0

    .line 33
    :catch_0
    move-exception v0

    .line 34
    .local v0, "ex":Ljava/lang/IllegalArgumentException;
    goto :goto_0
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/comcast/cim/microdata/model/FormFieldType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 6
    const-class v0, Lcom/comcast/cim/microdata/model/FormFieldType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/microdata/model/FormFieldType;

    return-object v0
.end method

.method public static values()[Lcom/comcast/cim/microdata/model/FormFieldType;
    .locals 1

    .prologue
    .line 6
    sget-object v0, Lcom/comcast/cim/microdata/model/FormFieldType;->$VALUES:[Lcom/comcast/cim/microdata/model/FormFieldType;

    invoke-virtual {v0}, [Lcom/comcast/cim/microdata/model/FormFieldType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/comcast/cim/microdata/model/FormFieldType;

    return-object v0
.end method
