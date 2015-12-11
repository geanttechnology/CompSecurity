.class final enum Lcom/poshmark/ui/fragments/MySizePickerFragment$MODE;
.super Ljava/lang/Enum;
.source "MySizePickerFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/fragments/MySizePickerFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4018
    name = "MODE"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/poshmark/ui/fragments/MySizePickerFragment$MODE;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/poshmark/ui/fragments/MySizePickerFragment$MODE;

.field public static final enum MY_SIZE:Lcom/poshmark/ui/fragments/MySizePickerFragment$MODE;

.field public static final enum SEARCH_FILTER:Lcom/poshmark/ui/fragments/MySizePickerFragment$MODE;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 48
    new-instance v0, Lcom/poshmark/ui/fragments/MySizePickerFragment$MODE;

    const-string v1, "MY_SIZE"

    invoke-direct {v0, v1, v2}, Lcom/poshmark/ui/fragments/MySizePickerFragment$MODE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/ui/fragments/MySizePickerFragment$MODE;->MY_SIZE:Lcom/poshmark/ui/fragments/MySizePickerFragment$MODE;

    new-instance v0, Lcom/poshmark/ui/fragments/MySizePickerFragment$MODE;

    const-string v1, "SEARCH_FILTER"

    invoke-direct {v0, v1, v3}, Lcom/poshmark/ui/fragments/MySizePickerFragment$MODE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/ui/fragments/MySizePickerFragment$MODE;->SEARCH_FILTER:Lcom/poshmark/ui/fragments/MySizePickerFragment$MODE;

    const/4 v0, 0x2

    new-array v0, v0, [Lcom/poshmark/ui/fragments/MySizePickerFragment$MODE;

    sget-object v1, Lcom/poshmark/ui/fragments/MySizePickerFragment$MODE;->MY_SIZE:Lcom/poshmark/ui/fragments/MySizePickerFragment$MODE;

    aput-object v1, v0, v2

    sget-object v1, Lcom/poshmark/ui/fragments/MySizePickerFragment$MODE;->SEARCH_FILTER:Lcom/poshmark/ui/fragments/MySizePickerFragment$MODE;

    aput-object v1, v0, v3

    sput-object v0, Lcom/poshmark/ui/fragments/MySizePickerFragment$MODE;->$VALUES:[Lcom/poshmark/ui/fragments/MySizePickerFragment$MODE;

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
    .line 48
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/poshmark/ui/fragments/MySizePickerFragment$MODE;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 48
    const-class v0, Lcom/poshmark/ui/fragments/MySizePickerFragment$MODE;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/fragments/MySizePickerFragment$MODE;

    return-object v0
.end method

.method public static values()[Lcom/poshmark/ui/fragments/MySizePickerFragment$MODE;
    .locals 1

    .prologue
    .line 48
    sget-object v0, Lcom/poshmark/ui/fragments/MySizePickerFragment$MODE;->$VALUES:[Lcom/poshmark/ui/fragments/MySizePickerFragment$MODE;

    invoke-virtual {v0}, [Lcom/poshmark/ui/fragments/MySizePickerFragment$MODE;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/poshmark/ui/fragments/MySizePickerFragment$MODE;

    return-object v0
.end method
