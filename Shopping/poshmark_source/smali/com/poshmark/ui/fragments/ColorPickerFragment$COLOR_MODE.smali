.class public final enum Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;
.super Ljava/lang/Enum;
.source "ColorPickerFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/fragments/ColorPickerFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "COLOR_MODE"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;

.field public static final enum COLOR_BROWSE:Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;

.field public static final enum COLOR_FILTER:Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;

.field public static final enum COLOR_LISTING_FLOW:Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 44
    new-instance v0, Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;

    const-string v1, "COLOR_BROWSE"

    invoke-direct {v0, v1, v2}, Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;->COLOR_BROWSE:Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;

    new-instance v0, Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;

    const-string v1, "COLOR_FILTER"

    invoke-direct {v0, v1, v3}, Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;->COLOR_FILTER:Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;

    new-instance v0, Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;

    const-string v1, "COLOR_LISTING_FLOW"

    invoke-direct {v0, v1, v4}, Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;->COLOR_LISTING_FLOW:Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;

    const/4 v0, 0x3

    new-array v0, v0, [Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;

    sget-object v1, Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;->COLOR_BROWSE:Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;

    aput-object v1, v0, v2

    sget-object v1, Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;->COLOR_FILTER:Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;

    aput-object v1, v0, v3

    sget-object v1, Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;->COLOR_LISTING_FLOW:Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;

    aput-object v1, v0, v4

    sput-object v0, Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;->$VALUES:[Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;

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
    .line 44
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 44
    const-class v0, Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;

    return-object v0
.end method

.method public static values()[Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;
    .locals 1

    .prologue
    .line 44
    sget-object v0, Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;->$VALUES:[Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;

    invoke-virtual {v0}, [Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;

    return-object v0
.end method
