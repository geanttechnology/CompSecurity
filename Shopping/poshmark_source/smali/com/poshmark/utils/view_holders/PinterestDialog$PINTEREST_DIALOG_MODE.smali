.class public final enum Lcom/poshmark/utils/view_holders/PinterestDialog$PINTEREST_DIALOG_MODE;
.super Ljava/lang/Enum;
.source "PinterestDialog.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/utils/view_holders/PinterestDialog;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "PINTEREST_DIALOG_MODE"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/poshmark/utils/view_holders/PinterestDialog$PINTEREST_DIALOG_MODE;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/poshmark/utils/view_holders/PinterestDialog$PINTEREST_DIALOG_MODE;

.field public static final enum POST_CONN:Lcom/poshmark/utils/view_holders/PinterestDialog$PINTEREST_DIALOG_MODE;

.field public static final enum PRE_CONN:Lcom/poshmark/utils/view_holders/PinterestDialog$PINTEREST_DIALOG_MODE;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 24
    new-instance v0, Lcom/poshmark/utils/view_holders/PinterestDialog$PINTEREST_DIALOG_MODE;

    const-string v1, "PRE_CONN"

    invoke-direct {v0, v1, v2}, Lcom/poshmark/utils/view_holders/PinterestDialog$PINTEREST_DIALOG_MODE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/view_holders/PinterestDialog$PINTEREST_DIALOG_MODE;->PRE_CONN:Lcom/poshmark/utils/view_holders/PinterestDialog$PINTEREST_DIALOG_MODE;

    new-instance v0, Lcom/poshmark/utils/view_holders/PinterestDialog$PINTEREST_DIALOG_MODE;

    const-string v1, "POST_CONN"

    invoke-direct {v0, v1, v3}, Lcom/poshmark/utils/view_holders/PinterestDialog$PINTEREST_DIALOG_MODE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/view_holders/PinterestDialog$PINTEREST_DIALOG_MODE;->POST_CONN:Lcom/poshmark/utils/view_holders/PinterestDialog$PINTEREST_DIALOG_MODE;

    const/4 v0, 0x2

    new-array v0, v0, [Lcom/poshmark/utils/view_holders/PinterestDialog$PINTEREST_DIALOG_MODE;

    sget-object v1, Lcom/poshmark/utils/view_holders/PinterestDialog$PINTEREST_DIALOG_MODE;->PRE_CONN:Lcom/poshmark/utils/view_holders/PinterestDialog$PINTEREST_DIALOG_MODE;

    aput-object v1, v0, v2

    sget-object v1, Lcom/poshmark/utils/view_holders/PinterestDialog$PINTEREST_DIALOG_MODE;->POST_CONN:Lcom/poshmark/utils/view_holders/PinterestDialog$PINTEREST_DIALOG_MODE;

    aput-object v1, v0, v3

    sput-object v0, Lcom/poshmark/utils/view_holders/PinterestDialog$PINTEREST_DIALOG_MODE;->$VALUES:[Lcom/poshmark/utils/view_holders/PinterestDialog$PINTEREST_DIALOG_MODE;

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
    .line 24
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/poshmark/utils/view_holders/PinterestDialog$PINTEREST_DIALOG_MODE;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 24
    const-class v0, Lcom/poshmark/utils/view_holders/PinterestDialog$PINTEREST_DIALOG_MODE;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/poshmark/utils/view_holders/PinterestDialog$PINTEREST_DIALOG_MODE;

    return-object v0
.end method

.method public static values()[Lcom/poshmark/utils/view_holders/PinterestDialog$PINTEREST_DIALOG_MODE;
    .locals 1

    .prologue
    .line 24
    sget-object v0, Lcom/poshmark/utils/view_holders/PinterestDialog$PINTEREST_DIALOG_MODE;->$VALUES:[Lcom/poshmark/utils/view_holders/PinterestDialog$PINTEREST_DIALOG_MODE;

    invoke-virtual {v0}, [Lcom/poshmark/utils/view_holders/PinterestDialog$PINTEREST_DIALOG_MODE;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/poshmark/utils/view_holders/PinterestDialog$PINTEREST_DIALOG_MODE;

    return-object v0
.end method
