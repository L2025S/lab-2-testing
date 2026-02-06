import { test, expect } from '@playwright/test';

test('page should be reachable', async ({ page }) => {
    await page.goto('http://localhost:8080/balance');
    await expect(page).toHaveURL('http://localhost:8080/balance');
});

test('page should show correct title', async ({ page }) => {
    await page.goto('http://localhost:8080/balance');
    await expect(page.locator('h1')).toHaveText('Your Account Balance');
});

test('balance should be displayed', async ({ page }) => {
    await page.goto('http://localhost:8080/balance');

    const balanceText = await page.locator('div span').innerText();

    expect(balanceText).not.toBe('');
    expect(Number(balanceText)).not.toBeNaN();
});

