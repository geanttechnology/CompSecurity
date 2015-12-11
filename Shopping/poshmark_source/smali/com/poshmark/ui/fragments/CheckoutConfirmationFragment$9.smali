.class synthetic Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$9;
.super Ljava/lang/Object;
.source "CheckoutConfirmationFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1008
    name = null
.end annotation


# static fields
.field static final synthetic $SwitchMap$com$poshmark$ui$fragments$CheckoutConfirmationFragment$FLOW_STATE:[I


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 170
    invoke-static {}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$FLOW_STATE;->values()[Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$FLOW_STATE;

    move-result-object v0

    array-length v0, v0

    new-array v0, v0, [I

    sput-object v0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$9;->$SwitchMap$com$poshmark$ui$fragments$CheckoutConfirmationFragment$FLOW_STATE:[I

    :try_start_0
    sget-object v0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$9;->$SwitchMap$com$poshmark$ui$fragments$CheckoutConfirmationFragment$FLOW_STATE:[I

    sget-object v1, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$FLOW_STATE;->GATHER_DETAILS:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$FLOW_STATE;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$FLOW_STATE;->ordinal()I

    move-result v1

    const/4 v2, 0x1

    aput v2, v0, v1
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    goto :goto_0
.end method
