.class final enum Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;
.super Ljava/lang/Enum;
.source "ListingEditorFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/fragments/ListingEditorFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4018
    name = "LISTING_STATES"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

.field public static final enum EDIT_LISTING:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

.field public static final enum EDIT_PHOTO:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

.field public static final enum FILTER_PHOTO:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

.field public static final enum GET_AVAILABILITY_STATUS:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

.field public static final enum GET_BRAND:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

.field public static final enum GET_CATEGORY:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

.field public static final enum GET_COLOR:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

.field public static final enum GET_CONDITION_STATUS:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

.field public static final enum GET_SIZE:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

.field public static final enum LISTING_SETUP_STATE:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

.field public static final enum NEW_PHOTO:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

.field public static final enum SHARE_LISTING:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 86
    new-instance v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    const-string v1, "LISTING_SETUP_STATE"

    invoke-direct {v0, v1, v3}, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;->LISTING_SETUP_STATE:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    .line 87
    new-instance v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    const-string v1, "EDIT_LISTING"

    invoke-direct {v0, v1, v4}, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;->EDIT_LISTING:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    .line 88
    new-instance v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    const-string v1, "EDIT_PHOTO"

    invoke-direct {v0, v1, v5}, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;->EDIT_PHOTO:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    .line 89
    new-instance v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    const-string v1, "FILTER_PHOTO"

    invoke-direct {v0, v1, v6}, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;->FILTER_PHOTO:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    .line 90
    new-instance v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    const-string v1, "NEW_PHOTO"

    invoke-direct {v0, v1, v7}, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;->NEW_PHOTO:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    .line 91
    new-instance v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    const-string v1, "GET_BRAND"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;->GET_BRAND:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    .line 92
    new-instance v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    const-string v1, "GET_SIZE"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;->GET_SIZE:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    .line 93
    new-instance v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    const-string v1, "GET_COLOR"

    const/4 v2, 0x7

    invoke-direct {v0, v1, v2}, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;->GET_COLOR:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    .line 94
    new-instance v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    const-string v1, "GET_CATEGORY"

    const/16 v2, 0x8

    invoke-direct {v0, v1, v2}, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;->GET_CATEGORY:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    .line 95
    new-instance v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    const-string v1, "GET_CONDITION_STATUS"

    const/16 v2, 0x9

    invoke-direct {v0, v1, v2}, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;->GET_CONDITION_STATUS:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    .line 96
    new-instance v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    const-string v1, "GET_AVAILABILITY_STATUS"

    const/16 v2, 0xa

    invoke-direct {v0, v1, v2}, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;->GET_AVAILABILITY_STATUS:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    .line 97
    new-instance v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    const-string v1, "SHARE_LISTING"

    const/16 v2, 0xb

    invoke-direct {v0, v1, v2}, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;->SHARE_LISTING:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    .line 85
    const/16 v0, 0xc

    new-array v0, v0, [Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    sget-object v1, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;->LISTING_SETUP_STATE:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    aput-object v1, v0, v3

    sget-object v1, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;->EDIT_LISTING:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    aput-object v1, v0, v4

    sget-object v1, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;->EDIT_PHOTO:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    aput-object v1, v0, v5

    sget-object v1, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;->FILTER_PHOTO:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    aput-object v1, v0, v6

    sget-object v1, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;->NEW_PHOTO:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;->GET_BRAND:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;->GET_SIZE:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;->GET_COLOR:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;->GET_CATEGORY:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;->GET_CONDITION_STATUS:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;->GET_AVAILABILITY_STATUS:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;->SHARE_LISTING:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    aput-object v2, v0, v1

    sput-object v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;->$VALUES:[Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

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
    .line 85
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 85
    const-class v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    return-object v0
.end method

.method public static values()[Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;
    .locals 1

    .prologue
    .line 85
    sget-object v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;->$VALUES:[Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    invoke-virtual {v0}, [Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    return-object v0
.end method
